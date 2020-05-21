package ioPractice;
import java.io.*;

import javax.swing.*;
public class ioProgress {

    public static void main(String[] temp) {
            String s1="123465789豆fnhsxiuns法奶农发发明佛尔澳门bc";
            byte b[]=new byte[3];
            ioProgress a=new ioProgress();

            try{
                FileOutputStream fo=new FileOutputStream("d:/word.txt");
                fo.write(s1.getBytes());
                FileInputStream fis = new FileInputStream("D:/word.txt");
                JFrame jf = new JFrame("dwa");
                ProgressMonitorInputStream in =
                        new ProgressMonitorInputStream(null,"读取文件",fis);
                while(fis.read(b)!=-1){
                    String s=new String(b);
                    System.out.println(s);
                    Thread.sleep(100);
                }
                fis.close();

            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

