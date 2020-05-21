package Network;

import org.junit.Test;

import java.io.*;
import java.net.*;

/**
 * @Author: YHQ
 * @Date: 2019/12/15 15:23
 */
public class test {
    @Test
    public void test(){
        Socket socket = null;
        PrintWriter out = null;
        try {
            ServerSocket ss = new ServerSocket(8888);
            Socket clien = ss.accept();
            System.out.println(clien.getInetAddress().getHostAddress()+":"+clien.getPort());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test1(){
        URL url = null;
        try {
            url = new URL("https://www.baidu.com");
            HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();
            httpUrlConn.setDoInput(true);
            httpUrlConn.setRequestMethod("GET");
            httpUrlConn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            //获取输入流
            InputStream input = httpUrlConn.getInputStream();
            //将字节输入流转换为字符输入流
            InputStreamReader read = new InputStreamReader(input, "utf-8");
            //为字符输入流添加缓冲
            BufferedReader br = new BufferedReader(read);
            // 读取返回结果
            int len ;
            char c[] = new char[100];
            while((len = br.read(c))!=-1){
                System.out.print(new String(c,0,len));
            }
            // 释放资源
            br.close();
            read.close();
            input.close();
            httpUrlConn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test3(){
        try {
            Socket s = new Socket("127.0.0.1",8888);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
