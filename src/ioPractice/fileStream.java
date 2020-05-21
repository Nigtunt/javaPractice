package ioPractice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class fileStream {
    public static void main(String[] args) {
        File f=new File("d://word.txt");
        try{
            FileOutputStream FO=new FileOutputStream(f);
            byte buy[]="苟利国家生死以，岂因祸福避趋之".getBytes();
            FO.write(buy);
            FO.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try{
            FileInputStream FI=new FileInputStream(f);
            byte buy[]=new byte[3];
            while(FI.read(buy)!=-1){
                System.out.println(new String(buy));
                Thread.sleep(100);
            }
            System.out.println(f.getPath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}