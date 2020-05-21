package Network.TcpTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class myTcp {
    private BufferedReader reader;
    private ServerSocket server;
    private Socket socket;
    void getserver(){
        try {
            server=new ServerSocket(8998);
            System.out.println("服务器套接字已经创建成功");
            while(true){
                System.out.println("等待客户机连接");
                socket=server.accept();
                reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
                getClientMessage();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void getClientMessage() {
        try {
            while(true){
                System.out.println("客户机"+reader.readLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("连接断开");
        }
        try {
            if(reader!=null){
                reader.close();
            }
            if(socket!=null){
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String args[]){
        myTcp tcp=new myTcp();
        tcp.getserver();
    }
}
