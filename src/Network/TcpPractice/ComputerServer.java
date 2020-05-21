package Network.TcpPractice;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ComputerServer {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(8001);
            while (!ss.isClosed()) {
                Socket s = ss.accept();
                InputStream ips = s.getInputStream();
                OutputStream ops = s.getOutputStream();
                InputStreamReader reader=new InputStreamReader(ips);

                String str = "欢迎进入程序\n2．编写TCP服务器程序，"
                        + "实现创建一个在8001端口上等待的ServerSocket"
                        + "对象，当接收到一个客户机的连接请求后，"
                        + "程序从与客户机建立了连接的Socket对象中获得输入输出"
                        + "流。通过输出流向客户机发送信息。";
                ops.write(str.getBytes());
                byte b[] = new byte[1024];
                ips.read(b);
                System.out.println(new String(b));
                ips.close();
                ops.close();
                s.close();
            }
            ss.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
