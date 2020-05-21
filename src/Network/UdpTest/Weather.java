package Network.UdpTest;


import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;


public class Weather extends Thread{
    String weather="1请222222";
    int port=9898;
    InetAddress inetAddress=null;
    MulticastSocket socket=null;
    Weather(){
        try {
            inetAddress=InetAddress.getByName("224.225.10.0");
            socket=new MulticastSocket(port);
            socket.setTimeToLive(1);
            socket.joinGroup(inetAddress);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void run(){
        while(true){
            DatagramPacket packet=null;
            byte data[]=weather.getBytes();
            packet=new DatagramPacket(data,data.length,inetAddress,port);
            System.out.println(new String(data));
            try {
                socket.send(packet);
                sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String args[]){
        Weather w=new Weather();
        w.start();
    }
}
