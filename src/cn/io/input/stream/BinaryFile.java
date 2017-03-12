/**
 * 深圳金融电子结算中心
 * Copyright (c) 1995-2017 All Rights Reserved.
 */
package cn.io.input.stream;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * 读取二进制文件
 * @author HuHui
 * @version $Id: BinaryFile.java, v 0.1 2017年3月12日 下午4:05:30 HuHui Exp $
 */
public class BinaryFile {

    /**
     * @param args
     * @throws Exception 
     */
    public static void main(String[] args) throws Exception {
        File file = new File("F:\\图片\\bing壁纸\\BingWallpaper-2017-03-12.jpg");
        byte[] read = BinaryFile.read(file);
        System.out.println(read.length);
        //        String content = new String(read);
        //        System.out.println(content);
    }

    public static byte[] read(File file) throws Exception {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
        byte[] b = new byte[bis.available()];
        bis.read(b);
        bis.close();
        return b;
    }

}
