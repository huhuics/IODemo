/**
 * 深圳金融电子结算中心
 * Copyright (c) 1995-2017 All Rights Reserved.
 */
package cn.nio.channel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 使用NIO读取并写文件
 * @author HuHui
 * @version $Id: ReadAndWriteFile.java, v 0.1 2017年3月12日 下午9:58:55 HuHui Exp $
 */
public class ReadAndWriteFile {

    /**
     * @param args
     * @throws Exception 
     */
    public static void main(String[] args) throws Exception {

        FileChannel fc = new FileOutputStream("F:\\io\\readAndWrite.txt").getChannel();

        for (int i = 0; i < 10000000; i++) {
            fc.write(ByteBuffer.wrap("H".getBytes()));
        }

        fc.close();

        fc = new FileInputStream("F:\\io\\readAndWrite.txt").getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        fc.read(buffer);
        buffer.flip();

        while (buffer.hasRemaining()) {
            System.out.print((char) buffer.get());
        }

    }
}
