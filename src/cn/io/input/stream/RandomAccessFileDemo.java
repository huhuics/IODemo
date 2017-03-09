/**
 * 深圳金融电子结算中心
 * Copyright (c) 1995-2017 All Rights Reserved.
 */
package cn.io.input.stream;

import java.io.File;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile测试类
 * @author HuHui
 * @version $Id: RandomAccessFileDemo.java, v 0.1 2017年3月9日 下午10:19:53 HuHui Exp $
 */
public class RandomAccessFileDemo {

    /**
     * @param args
     * @throws Exception 
     */
    public static void main(String[] args) throws Exception {

        RandomAccessFile raf = new RandomAccessFile(new File("F:\\io\\io学习.txt"), "rw");

        raf.writeChars("RandomAccessFileDemo");

        raf.close();

    }
}
