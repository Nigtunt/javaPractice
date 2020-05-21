package ioPractice;

import org.junit.Test;

import java.io.*;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

/**
 * @Author: YHQ
 * @Date: 2019/12/5 19:22
 */
public class CharacterStream {
    @Test
    public void test1() throws Exception{
        Reader reader= null;
        reader = new FileReader("d://word.txt");
        int len ;
        while ((len = reader.read())!=-1)
            System.out.print((char)len);
        System.out.println();
        reader = new FileReader("d://word.txt");
        char [] c= new char[1024];
        len = reader.read(c);
        System.out.println(new String(c,0,len));

    }

    @Test
    public void test2() throws Exception{
        Writer writer = null;
        writer = new FileWriter("d://test2.txt");
        writer.write(60);
        writer.write("215");
        writer.write("absdbawudba",5,5);
        writer.flush();
        System.out.println(Charset.defaultCharset());
    }
    @Test
    public void test3() throws Exception{
        FileOutputStream f = new FileOutputStream("d://Product.txt");
        OutputStreamWriter ow = new OutputStreamWriter(f);
        ow.write("dwad达瓦发发我发发发发我");
        ow.flush();

        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("d://Product.txt")
                )
        );
        String str = br.readLine();
        System.out.println(str);
        br.close();

    }
}
