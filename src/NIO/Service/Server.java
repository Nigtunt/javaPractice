package NIO.Service;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * @Author: YHQ
 * @Date: 2020/2/27 14:06
 */
public class Server {
    void start() throws IOException {
        Selector selector = Selector.open();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8000));
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        for (;;){
            int count = selector.select();

            if(count==0) continue;

            Set<SelectionKey> selectionKeys = selector.selectedKeys();

            Iterator<SelectionKey> iterator = selectionKeys.iterator();

            while (iterator.hasNext()){
                SelectionKey selectionKey = iterator.next();
                iterator.remove();
                //接入事件
                if (selectionKey.isAcceptable())
                    acceptHandle(serverSocketChannel,selector);
                //可读事件
                if (selectionKey.isReadable())
                    readHandle(selector,selectionKey);
            }
        }
    }
    private void readHandle(Selector selector,SelectionKey selectionKey) throws IOException {
        SocketChannel channel = (SocketChannel) selectionKey.channel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        String request = "";
        while (channel.read(byteBuffer)>0){
            byteBuffer.flip();
            request += Charset.forName("utf-8").decode(byteBuffer);
        }
        channel.register(selector,SelectionKey.OP_READ);

        if (request.length()>0){
            boradcast(selector,channel,request);
        }
    }
    private void acceptHandle(ServerSocketChannel serverSocketChannel
                    ,Selector selector) throws IOException {
        SocketChannel accept = serverSocketChannel.accept();

        accept.configureBlocking(false);

        accept.register(selector,SelectionKey.OP_READ);
        accept.write(Charset.forName("utf-8").encode("已接入"));

    }
    private void boradcast(Selector selector,
                           SocketChannel accept,
                           String request){
        Set<SelectionKey> keys = selector.keys();

        keys.forEach(selectionKey -> {
            Channel channel = selectionKey.channel();
            //剔除发消息的客户端
            if (channel instanceof SocketChannel && channel != accept){
                try {
                    ((SocketChannel) channel).write(Charset.forName("utf-8")
                    .encode(request));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public static void main(String args[]) throws IOException {
        Server s = new Server();
        s.start();
    }
}
