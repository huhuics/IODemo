/**
 * 深圳金融电子结算中心
 * Copyright (c) 1995-2017 All Rights Reserved.
 */
package cn.nio.simple.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * NIO实现Socket客户端
 * @author HuHui
 * @version $Id: Client.java, v 0.1 2017年3月24日 上午10:25:04 HuHui Exp $
 */
public class Client {

    private SocketChannel     client = null;

    private InetSocketAddress isa    = null;

    private RecvThread        rt     = null;

    public Client() {

    }

    public static void main(String[] args) {
        Client client = new Client();
        client.makeConnection();
    }

    /**
     * 创建连接
     */
    public void makeConnection() {
        int result = 0;

        try {
            client = SocketChannel.open();
            isa = new InetSocketAddress("127.0.0.1", Server.port);
            client.connect(isa);
            client.configureBlocking(false);
            receiveMessage();
        } catch (IOException e) {
            System.out.println("创建socket连接异常");
        }

        while ((result = sendMessage()) != -1) {

        }

        try {
            client.close();
        } catch (IOException e) {
        }

    }

    private int sendMessage() {
        System.out.println("Client.sendMessage");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String msg = null;
        ByteBuffer byteBuf = ByteBuffer.allocate(1024);
        int nBytes = 0;
        try {
            msg = in.readLine();
            System.out.println("msg  is " + msg);
            byteBuf = ByteBuffer.wrap(msg.getBytes());
            nBytes = client.write(byteBuf);
            System.out.println("nBytes is " + nBytes);
            if (msg.equals("quit") || msg.equals("shutdown")) {
                System.out.println("time to stop the client");
                interruptThread();
                client.close();
                return -1;
            }
        } catch (Exception e) {
        }

        System.out.println("Wrote " + nBytes + " bytes to the server");
        return nBytes;
    }

    public void receiveMessage() {
        rt = new RecvThread("Receive Thread", client);
        rt.start();
    }

    public void interruptThread() {
        rt.val = false;
    }

    /**
     * 接收数据线程
     */
    class RecvThread extends Thread {

        private SocketChannel sc  = null;

        private boolean       val = true;

        public RecvThread(String str, SocketChannel sc) {
            super(str);
            this.sc = sc;
        }

        @Override
        public void run() {

            System.out.println("接收数据线程启动");

            int nBytes = 0;

            ByteBuffer buf = ByteBuffer.allocate(2048);

            try {
                while (val) {
                    while ((nBytes = client.read(buf)) > 0) {
                        buf.flip();
                        Charset charset = Charset.forName("UTF-8");
                        CharsetDecoder decoder = charset.newDecoder();
                        CharBuffer charBuffer = decoder.decode(buf);
                        String result = charBuffer.toString();
                        System.out.println("收到数据=" + result);
                        buf.flip();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

}
