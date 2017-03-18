/**
 * 深圳金融电子结算中心
 * Copyright (c) 1995-2017 All Rights Reserved.
 */
package cn.nio.channel;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 使用AsynchronousFileChannel读取文件
 * @author HuHui
 * @version $Id: AsynChannel.java, v 0.1 2017年3月18日 下午3:59:31 HuHui Exp $
 */
public class AsynChannel {

    /**
     * @param args
     * @throws Exception 
     */
    public static void main(String[] args) throws Exception {

        Path path = Paths.get("F:\\io\\asyn.txt");

        AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(path, StandardOpenOption.READ);

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        long position = 0;

        /* Future<Integer> operation = fileChannel.read(buffer, position);

         while (!operation.isDone()) {
             System.out.println("正在读");
         }

         buffer.flip();
         byte[] data = new byte[buffer.limit()];
         buffer.get(data);

         System.out.println(new String(data));
         buffer.clear();*/

        fileChannel.read(buffer, position, buffer, new CompletionHandler<Integer, ByteBuffer>() {

            @Override
            public void completed(Integer result, ByteBuffer attachment) {
                System.out.println("进入completed方法,result=" + result);
                attachment.flip();
                byte[] data = new byte[attachment.limit()];
                attachment.get(data);
                System.out.println(new String(data));
                attachment.clear();
            }

            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {
                System.out.println("failed");
                throw new RuntimeException(exc);
            }
        });

    }

}
