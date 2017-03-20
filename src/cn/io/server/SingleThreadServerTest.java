/**
 * 深圳金融电子结算中心
 * Copyright (c) 1995-2017 All Rights Reserved.
 */
package cn.io.server;

/**
 * 测试单线程服务器
 * @author HuHui
 * @version $Id: SingleThreadServerTest.java, v 0.1 2017年3月19日 下午3:22:01 HuHui Exp $
 */
public class SingleThreadServerTest {

    /**
     * @param args
     * @throws InterruptedException 
     */
    public static void main(String[] args) throws InterruptedException {

        SingleThreadServer server = new SingleThreadServer(9000);
        new Thread(server).start();

        //        Thread.sleep(10 * 1000);
        //
        //        System.out.println("Stopping Server");
        //
        //        server.stop();

    }

}
