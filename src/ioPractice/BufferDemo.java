package ioPractice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

public class BufferDemo {
    public static void main(String[] args) {
        String content[]= {"好久不见","最近好吗","常联系"};
        File f=new File("D:\\BufferedWord.txt");
        if(!f.exists()) {
            try {
                f.createNewFile();
            }catch(Exception e) {
                e.printStackTrace();
            }

        }
        try {
            FileWriter FW=new FileWriter(f);
            BufferedWriter BW=new BufferedWriter(FW);
            for(int i=0;i<content.length;i++) {
                BW.write(content[i]);
                BW.newLine();
            }
            BW.close();
            FW.close();

        }catch(Exception e) {
            e.printStackTrace();
        }
        try {
            FileInputStream FIS=new FileInputStream(f);
            FileReader FR=new FileReader(f);
            BufferedReader BR=new BufferedReader(FR);
            String s=null;
            while((s=BR.readLine())!=null)
                System.out.println(s);
            byte[]b=new byte[1024];
            int len=FIS.read(b);
            System.out.println(new String(b,0,len));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}