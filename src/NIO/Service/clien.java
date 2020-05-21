package NIO.Service;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Scanner;

/**
 * @Author: YHQ
 * @Date: 2020/2/27 14:09
 */
public class clien {

    private void start() throws IOException {
        SocketChannel open = SocketChannel.open(
                new InetSocketAddress("127.0.0.1",8000));
        Selector selector = Selector.open();
        open.configureBlocking(false);
        open.register(selector, SelectionKey.OP_READ);
        new Thread(new clienHandle(selector)).start();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String request = scanner.nextLine();
            if (request!=null&&request.length()>0){
                open.write(Charset.forName("utf-8").encode(request));
            }
        }
    }
    public static void main(String args[]) throws IOException {
        new clien().start();
    }
}
