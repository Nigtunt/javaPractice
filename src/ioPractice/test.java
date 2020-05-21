package ioPractice;

import Algorithm.dataStructure.User;
import org.junit.Test;

import java.io.*;
import java.lang.reflect.Constructor;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: YHQ
 * @Date: 2019/12/1 10:23
 */
public class test {
    @Test
    public void test1(){
        try {
            File f = new File("d://readtest.txt");
            if (!f.exists()){
                f.createNewFile();
                OutputStream ot= new FileOutputStream(f);
                ot.write("dhuwiahdha嫉妒我阿飞好哦放假啊".getBytes());
                ot.write("dwadad".getBytes());
                ot.write("dwa工农日感觉\n".getBytes());
                ot.close();
            }
            OutputStream ot= new FileOutputStream(f,true);
            ot.write("dhuwiahdha嫉妒我阿飞好哦放假啊".getBytes());
            ot.write("dwadad".getBytes());
            ot.write("dwa工农日感觉\n".getBytes());
            ot.close();
            InputStream input = new FileInputStream(f);

            byte []b = new byte[1024];
            int total = input.available();
            int count = input.read(b);
            System.out.println(total+"+" + count);
            System.out.println(new String(b,0,count));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * 高级流 对象流写入
     */
    @Test
    public void test2() throws Exception{
        int a = 114514;
        double b = 19.19;
        String c = "810";
        char d = 'a';
        Date e = new Date();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream((
                new FileOutputStream("d://readtest.txt")));

        objectOutputStream.writeInt(a);
        objectOutputStream.writeDouble(b);
        objectOutputStream.writeUTF(c);
        objectOutputStream.writeChar(d);
        objectOutputStream.writeObject(e);
        objectOutputStream.close();
    }

    /**
     * 高级流 对象流的读出
     */
    @Test
    public void test3() throws Exception{
        ObjectInputStream oj = new ObjectInputStream(new FileInputStream("d://readtest.txt"));

        int a = oj.readInt();
        double b = oj.readDouble();
        String c = oj.readUTF();
        char d = oj.readChar();
        Object e = oj.readObject();
        System.out.println(a+":"+b+":"+c+":"+d+":"+e);
    }

    /**
     * 序列化  写入的类必须有可序列化接口
     */
    @Test
    public void test4(){
        User u = new User(114,"野兽",514);
        ObjectOutputStream ojo= null;
        try {
            ojo = new ObjectOutputStream(new FileOutputStream("d://yeshou.txt"));
            ojo.writeObject(u);
            ojo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 读出自己的类
     */
    @Test
    public void test5(){
        ObjectInputStream oi = null;
        User u = null;
        try {
            oi = new ObjectInputStream(new FileInputStream("d://yeshou.txt"));
            u = (User) oi.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(u);
    }

    @Test
    public void test6(){
        System.out.println(System.getProperties());
        System.out.println(System.getProperty("sun.cpu.isalist"));
    }

    private void f(File f,int level){
        for (int i=0;i<level;i++)
            System.out.print("|----");
        if (f.isDirectory()){
            System.out.println("["+f.getName()+"]");
            File files[] = f.listFiles();
            for (int i = 0; i < files.length; i++) {
                f(files[i],level+1);
            }
        }else
            System.out.println(f.getName());
    }
    @Test
    public void test7(){
        File f = new File("D:\\BaiduYunDownload\\ShadowsocksR-4.7.0-win");
        f(f,0);
    }
}
