/**
 * 深圳金融电子结算中心
 * Copyright (c) 1995-2017 All Rights Reserved.
 */
package cn.io.file;

import java.io.File;
import java.io.IOException;

/**
 * File学习类
 * @author HuHui
 * @version $Id: MyFile.java, v 0.1 2017年3月9日 下午7:26:20 HuHui Exp $
 */
public class MyFile {

    /**
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        File file = new File("F:\\io\\io学习.txt");

        if (!file.exists()) {
            file.createNewFile();
        }

        System.out.println("canRead=" + file.canRead());
        System.out.println("canWrite=" + file.canWrite());
        System.out.println("getName=" + file.getName());
        System.out.println("getParent=" + file.getParent());
        System.out.println("absolutePath=" + file.getAbsolutePath());

        file = new File("F:\\io\\io练习.txt");
        if (!file.exists()) {
            file.createNewFile();
        }

        file = new File("F:\\io\\");
        String[] list = file.list();
        for (String str : list) {
            System.out.println(str);
        }

        boolean delete = file.delete();
        System.out.println(delete);

    }
}
