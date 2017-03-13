/**
 * 深圳金融电子结算中心
 * Copyright (c) 1995-2017 All Rights Reserved.
 */
package cn.nio.buffer;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 使用ByteBuffer读文件
 * @author HuHui
 * @version $Id: ByteRead.java, v 0.1 2017年3月13日 下午10:10:10 HuHui Exp $
 */
public class ByteRead {

    /**
     * @param args
     * @throws Exception 
     */
    public static void main(String[] args) throws Exception {

        RandomAccessFile aFile = new RandomAccessFile("F:\\io\\io.txt", "rw");

        FileChannel inChannel = aFile.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(48);

        int bytesRead = inChannel.read(buf);

        int i = 1;

        while (bytesRead != -1) {
            System.out.println("进入第" + i++ + "次循环");
            buf.flip();//准备读
            while (buf.hasRemaining()) {
                System.out.print((char) buf.get());//每次读取1byte
            }

            buf.clear();
            bytesRead = inChannel.read(buf);
        }

        aFile.close();

    }

}
