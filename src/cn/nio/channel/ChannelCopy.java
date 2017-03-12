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
 * 通道复制实现文件复制
 * @author HuHui
 * @version $Id: ChannelCopy.java, v 0.1 2017年3月12日 下午5:47:21 HuHui Exp $
 */
public class ChannelCopy {

    private static final int SIZE = 1024;

    /**
     * @param args
     * @throws Exception 
     */
    public static void main(String[] args) throws Exception {
        ChannelCopy cc = new ChannelCopy();
        cc.copyFile();
    }

    public void copyFile() throws Exception {

        FileChannel inChannel = new FileInputStream("F:\\io\\io学习.txt").getChannel();
        FileChannel outChannel = new FileOutputStream("F:\\io\\io测试.txt").getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(SIZE);
        while (inChannel.read(buffer) != -1) {
            buffer.flip();
            outChannel.write(buffer);
            buffer.clear();
        }

    }

}
