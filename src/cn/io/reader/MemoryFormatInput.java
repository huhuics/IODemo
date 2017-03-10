/**
 * 深圳金融电子结算中心
 * Copyright (c) 1995-2017 All Rights Reserved.
 */
package cn.io.reader;

import java.io.DataInputStream;
import java.io.FileInputStream;

/**
 * 格式化内存读取,每次只读一个字节
 * @author HuHui
 * @version $Id: MemoryFormatInput.java, v 0.1 2017年3月10日 下午8:08:34 HuHui Exp $
 */
public class MemoryFormatInput {

    /**
     * @param args
     * @throws Exception 
     */
    public static void main(String[] args) throws Exception {

        DataInputStream dis = new DataInputStream(new FileInputStream("F:\\io\\io学习.txt"));

        byte b;
        while (dis.available() != 0) {
            b = dis.readByte();
            System.out.print((char) b);
        }

        dis.close();

    }
}
