/**
 * 深圳金融电子结算中心
 * Copyright (c) 1995-2017 All Rights Reserved.
 */
package cn.nio.simple.server;

import java.io.IOException;
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
        System.exit(0);

    }

    private int sendMessage() {
        return 0;
    }

    private void receiveMessage() {
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
