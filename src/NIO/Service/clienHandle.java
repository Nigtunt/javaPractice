package NIO.Service;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * @Author: YHQ
 * @Date: 2020/2/27 15:19
 */
public class clienHandle implements Runnable {
    private Selector selector;

    public clienHandle(Selector selector) {
        this.selector = selector;
    }

    @Override
    public void run() {
        for (;;){
            try {
                int count = selector.select();
                if (count == 0)
                    continue;
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()){
                    SelectionKey next = iterator.next();
                    iterator.remove();

                    if (next.isReadable()){
                        readHandle(selector,next);
                    }

                }
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }
    private void readHandle(Selector selector,SelectionKey selectionKey) throws IOException {
        SocketChannel channel = (SocketChannel) selectionKey.channel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        StringBuilder request = new StringBuilder();
        while (channel.read(byteBuffer)>0){
            byteBuffer.flip();
            request.append(Charset.forName("utf-8").decode(byteBuffer));
        }
        channel.register(selector,SelectionKey.OP_READ);
        if (request.length()>0){
            System.out.println(request.toString());
        }
    }
}
