/**
 * 深圳金融电子结算中心
 * Copyright (c) 1995-2017 All Rights Reserved.
 */
package cn.io.input.stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * 标准输出重定向
 * @author HuHui
 * @version $Id: Redirecting.java, v 0.1 2017年3月12日 下午4:32:11 HuHui Exp $
 */
public class Redirecting {

    /**
     * @param args
     * @throws Exception 
     */
    public static void main(String[] args) throws Exception {
        Redirecting r = new Redirecting();
        r.redirect();
    }

    public void redirect() throws Exception {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("F:\\io\\io学习.txt"));
        System.setIn(bis);

        PrintStream ps = new PrintStream(new BufferedOutputStream(new FileOutputStream("F:\\io\\io测试.txt")));
        System.setOut(ps);

        String testStr = "this is a test string";
        System.out.println(testStr);
        bis.close();
        ps.close();
    }
}
