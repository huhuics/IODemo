/**
 * 深圳金融电子结算中心
 * Copyright (c) 1995-2017 All Rights Reserved.
 */
package cn.io.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * 使用BufferedReader读取文件
 * @author HuHui
 * @version $Id: BufferedInputFile.java, v 0.1 2017年3月10日 下午7:35:14 HuHui Exp $
 */
public class BufferedInputFile {

    /**
     * @param args
     * @throws Exception 
     */
    public static void main(String[] args) throws Exception {
        String content = BufferedInputFile.read("F:\\io\\io学习.txt");
        System.out.println(content);
    }

    public static String read(String path) throws Exception {

        File file = new File(path);

        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line + "\n");
        }

        br.close();

        return sb.toString();

    }
}
