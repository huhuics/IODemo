/**
 * 深圳金融电子结算中心
 * Copyright (c) 1995-2017 All Rights Reserved.
 */
package cn.io.reader;

import java.io.StringReader;

/**
 * 内存读文件
 * @author HuHui
 * @version $Id: MemoryInput.java, v 0.1 2017年3月10日 下午7:52:18 HuHui Exp $
 */
public class MemoryInput {

    public static void main(String[] args) throws Exception {

        StringReader sr = new StringReader(BufferedInputFile.read("F:\\io\\io学习.txt"));

        int i;
        while ((i = sr.read()) != -1) {
            System.out.print((char) i);
        }

        sr.close();
    }
}
