/**
 * 深圳金融电子结算中心
 * Copyright (c) 1995-2017 All Rights Reserved.
 */
package cn.io.writer;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 测试DataOutputStream和DataInputStream
 * @author HuHui
 * @version $Id: ReadAndWriteFile.java, v 0.1 2017年3月10日 下午8:35:32 HuHui Exp $
 */
public class ReadAndWriteFile {

    /**
     * @param args
     * @throws Exception 
     */
    public static void main(String[] args) throws Exception {

        File file = new File("F:\\io\\ReadAndWriteFile");
        if (!file.exists()) {
            file.createNewFile();
        }

        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));

        dos.writeUTF("this is pi:");
        dos.writeUTF("这是pi:");
        dos.writeDouble(3.1415);

        dos.close();

        DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
        System.out.println(dis.readUTF());
        System.out.println(dis.readUTF());
        System.out.println(dis.readDouble());
        dis.close();

    }
}
