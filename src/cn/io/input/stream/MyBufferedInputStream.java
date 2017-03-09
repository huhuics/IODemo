/**
 * 深圳金融电子结算中心
 * Copyright (c) 1995-2017 All Rights Reserved.
 */
package cn.io.input.stream;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * BufferedInputStream测试
 * @author HuHui
 * @version $Id: MyBufferedInputStream.java, v 0.1 2017年3月9日 下午8:26:42 HuHui Exp $
 */
public class MyBufferedInputStream {

    /**
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {

        InputStream is = new BufferedInputStream(new FileInputStream(new File("F:\\io\\io学习.txt")));

        byte[] b = new byte[1024];
        while (is.read(b) != -1) {
            String str = new String(b, Charset.forName("UTF-8"));
            System.out.println(str);
        }

        is.close();

    }
}
