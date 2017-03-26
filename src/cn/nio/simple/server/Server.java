/**
 * 深圳金融电子结算中心
 * Copyright (c) 1995-2017 All Rights Reserved.
 */
package cn.nio.simple.server;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.Iterator;
import java.util.Set;

/**
 * NIO实现Socket服务器端
 * @author HuHui
 * @version $Id: Server.java, v 0.1 2017年3月22日 下午8:29:04 HuHui Exp $
 */
public class Server {

    public Selector            selector      = null;

    public ServerSocketChannel serverChannel = null;

    public SocketChannel       socket        = null;

    public static int          port          = 8088;

    public String              result        = null;

    public Server() {
        System.out.println("服务器在默认端口监听,port=" + port);
    }

    public Server(int port) {
        Server.port = port;
        System.out.println("服务器在端口" + port + "监听");
    }

    /**
     * 初始化参数
     * @throws IOException 
     */
    private void init() throws IOException {
        System.out.println("初始化");

        //初始化
        selector = Selector.open();
        serverChannel = ServerSocketChannel.open();
        serverChannel.configureBlocking(false);

        InetSocketAddress address = new InetSocketAddress("127.0.0.1", port);

        //绑定端口并监听
        serverChannel.socket().bind(address);

    }

    /**
     * 启动服务器
     * @throws IOException 
     */
    public void startServer() throws IOException {
        System.out.println("开始启动服务器");

        init();

        //注册Selector
        SelectionKey acceptKey = serverChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (acceptKey.selector().select() > 0) {

            //获取已经准备好的SelectionKey
            Set<SelectionKey> readyKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = readyKeys.iterator();

            //遍历SelectionKey
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();

                if (key.isAcceptable()) { //a connection was accepted by a ServerSocketChannel
                    System.out.println("key.isAcceptable");
                    ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
                    socket = ssc.accept();
                    socket.configureBlocking(false);
                    socket.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);

                } else if (key.isReadable()) { //channel is ready for reading
                    System.out.println("key.isReadable");
                    String ret = readMessage(key);
                    if (ret.length() > 0) {
                        writeMessage(socket, ret);
                    }

                } else if (key.isWritable()) { //channel is ready for writing
                    System.out.println("key.isWritable");
                    String ret = readMessage(key);
                    socket = (SocketChannel) key.channel();
                    if (result.length() > 0) {
                        writeMessage(socket, ret);
                    }

                }

                iterator.remove();

            }

        }

    }

    /**
     * 写信息
     * @param socket
     * @param ret
     */
    private void writeMessage(SocketChannel socket, String ret) {

        if (ret.equals("quit") || ret.equals("shutdown")) {
            return;
        }

        File file = new File(ret);

        try {
            RandomAccessFile rdm = new RandomAccessFile(file, "r");
            FileChannel fc = rdm.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            fc.read(buffer);
            buffer.flip();

            Charset set = Charset.forName("UTF-8");
            CharsetDecoder dec = set.newDecoder();
            CharBuffer charBuf = dec.decode(buffer);
            System.out.println(charBuf.toString());

            buffer = ByteBuffer.wrap((charBuf.toString()).getBytes());
            int nBytes = socket.write(buffer);
            System.out.println("write nBytes=" + nBytes);

            result = null;

            fc.close();
            rdm.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 读信息
     * @param key
     * @return
     */
    private String readMessage(SelectionKey key) {

        int nBytes = 0;

        socket = (SocketChannel) key.channel();

        ByteBuffer buf = ByteBuffer.allocate(1024);

        try {
            nBytes = socket.read(buf);
            buf.flip(); //ready to read

            Charset charset = Charset.forName("UTF-8");
            CharsetDecoder decoder = charset.newDecoder();
            CharBuffer charBuffer = decoder.decode(buf);
            result = charBuffer.toString();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {

        Server server = new Server();

        server.startServer();

    }

}
