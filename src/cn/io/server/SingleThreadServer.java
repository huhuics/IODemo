/**
 * 深圳金融电子结算中心
 * Copyright (c) 1995-2017 All Rights Reserved.
 */
package cn.io.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 单线程实现服务器
 * @author HuHui
 * @version $Id: SingleThreadServer.java, v 0.1 2017年3月19日 下午3:05:32 HuHui Exp $
 */
public class SingleThreadServer implements Runnable {

    protected int          serverPort    = 8080;

    protected ServerSocket serverSocket  = null;

    protected boolean      isStopped     = false;

    protected Thread       runningThread = null;

    public SingleThreadServer(int port) {
        this.serverPort = port;
    }

    @Override
    public void run() {

        synchronized (this) {
            this.runningThread = Thread.currentThread();
        }

        openServerSocket();

        while (!isStopped()) {
            Socket clientSocket = null;

            try {
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                if (isStopped()) {
                    System.out.println("Server stopped");
                    return;
                }
                throw new RuntimeException("Error accepting client connection", e);
            }

            try {
                processClientRequest(clientSocket);
            } catch (IOException e) {

            }
        }

        System.out.println("Server Stopped");
    }

    private void processClientRequest(Socket clientSocket) throws IOException {
        InputStream input = clientSocket.getInputStream();

        byte[] b = new byte[1024];
        if (input.read(b) != -1) {
            System.out.println(new String(b));
        }

        OutputStream output = clientSocket.getOutputStream();

        long time = System.currentTimeMillis();

        output.write(("HTTP/1.1 200 OK\n\n<html><body>" + "Singlethreaded Server: " + time + "</body></html>").getBytes());
        output.flush();
        output.close();
        input.close();

        System.out.println("Request processed:" + (System.currentTimeMillis() - time) + "ms");
    }

    public synchronized void stop() {
        this.isStopped = true;
        try {
            this.serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException("Error closing server", e);
        }
    }

    private synchronized boolean isStopped() {
        return isStopped;
    }

    private void openServerSocket() {
        try {
            this.serverSocket = new ServerSocket(serverPort);
        } catch (IOException e) {
            throw new RuntimeException("无法监听端口" + serverPort, e);
        }
    }

}
