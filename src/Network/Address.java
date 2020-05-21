package Network;

import java.net.InetAddress;
import java.net.UnknownHostException;
public class Address {
    public static void main(String args[]){
        InetAddress ip;
        try {
            ip=InetAddress.getByName("14.215.177.39");
            String localname=ip.getHostName();
            String localip=ip.getHostAddress();
            System.out.println("本机名"+localname);
            System.out.println("本机ip"+localip);
            ip = InetAddress.getByName("localhost");// 修改为指定的主机名称
            System.out.println("主机名：" + ip.getHostName());
            System.out.println("主机IP地址：" + ip.getHostAddress());
            System.out.println("本机IP地址："
                    + InetAddress.getLocalHost().getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
