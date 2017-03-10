/**
 * 深圳金融电子结算中心
 * Copyright (c) 1995-2017 All Rights Reserved.
 */
package cn.io.writer;

import java.io.File;
import java.io.FileOutputStream;

/**
 * 测试FileOutputStream
 * @author HuHui
 * @version $Id: FileOutputFile.java, v 0.1 2017年3月10日 下午8:45:57 HuHui Exp $
 */
public class FileOutputFile {

    /**
     * @param args
     * @throws Exception 
     */
    public static void main(String[] args) throws Exception {

        File file = new File("F:\\io\\FileOutputFile");
        if (!file.exists()) {
            file.createNewFile();
        }

        FileOutputStream fos = new FileOutputStream(file, true);
        String str = "我是胡辉";
        fos.write(str.getBytes());

        fos.close();

    }

}
