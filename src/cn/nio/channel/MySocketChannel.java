/**
 * 深圳金融电子结算中心
 * Copyright (c) 1995-2017 All Rights Reserved.
 */
package cn.nio.channel;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * 
 * @author HuHui
 * @version $Id: MySocketChannel.java, v 0.1 2017年3月14日 下午9:15:44 HuHui Exp $
 */
public class MySocketChannel {

    /**
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {

        SocketChannel channel = SocketChannel.open();

        Selector selector = Selector.open();

        channel.configureBlocking(false);

        SelectionKey key = channel.register(selector, SelectionKey.OP_READ);

        while (true) {

            int readyChannels = selector.select();
            if (readyChannels == 0) {
                continue;
            }

            Set<SelectionKey> selectedKeys = selector.selectedKeys();

            Iterator<SelectionKey> keyIterator = selectedKeys.iterator();

            while (keyIterator.hasNext()) {

                SelectionKey nextKey = keyIterator.next();

                if (nextKey.isAcceptable()) {

                } else if (nextKey.isConnectable()) {

                } else if (nextKey.isReadable()) {

                } else if (nextKey.isWritable()) {

                }

                keyIterator.remove();
            }

        }

    }

}
