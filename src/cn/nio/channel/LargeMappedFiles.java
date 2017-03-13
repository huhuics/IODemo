/**
 * 深圳金融电子结算中心
 * Copyright (c) 1995-2017 All Rights Reserved.
 */
package cn.nio.channel;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 操作大文件
 * @author HuHui
 * @version $Id: LargeMappedFiles.java, v 0.1 2017年3月12日 下午9:26:22 HuHui Exp $
 */
public class LargeMappedFiles {

    /**
     * @param args
     * @throws Exception 
     * @throws FileNotFoundException 
     */
    public static void main(String[] args) throws Exception {

        final int length = 0X8FFFFFF;
        MappedByteBuffer out = new RandomAccessFile("F:\\io\\largeFile", "rw").getChannel().map(FileChannel.MapMode.READ_WRITE, 0, length);

        for (int i = 0; i < length; i++) {
            out.put((byte) 'x');
        }

        System.out.println("完成写入");

        for (int i = length / 2; i < length / 2 + 6; i++) {
            System.out.println((char) out.get(i));
        }

    }
}
