/**
 * 深圳金融电子结算中心
 * Copyright (c) 1995-2017 All Rights Reserved.
 */
package cn.nio.channel;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 * 测试ByteBuffer保存基本类型
 * @author HuHui
 * @version $Id: GetData.java, v 0.1 2017年3月12日 下午7:50:15 HuHui Exp $
 */
public class GetData {

    /**
     * @param args
     */
    public static void main(String[] args) {

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        System.out.println("limit=" + buffer.limit());

        buffer.asIntBuffer().put(123213);
        System.out.println(buffer.getInt());

        buffer.rewind();

        buffer.asLongBuffer().put(567L);
        System.out.println(buffer.getLong());

        IntBuffer ib = buffer.asIntBuffer();
        ib.put(new int[] { 11, 42, 47, 99 });

        ib.flip();

        while (ib.hasRemaining()) {
            System.out.print(ib.get() + ",");
        }

    }

}
