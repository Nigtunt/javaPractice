package Test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * @Author: YHQ
 * @Date: 2019/12/24 14:04
 */
public class TestLog4j {
    int a = 10;
    String str = "15616";

    public static void main(String args[]) throws Exception{
        Properties prop = new Properties();
        File f = new File("log4j.properties");

        System.out.println(f.exists());
        FileInputStream g = new FileInputStream("log4j.properties");
        prop.load(g);
        prop.list(System.out);

    }
}
