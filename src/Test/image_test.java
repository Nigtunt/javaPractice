package Test;

import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author: YHQ
 * @Date: 2020/3/14 13:51
 */
public class image_test {
    @Test
     public void test() throws IOException {
        BufferedImage bi = ImageIO.read(new File("d:/testtu.jpg"));
        BufferedImage newbi = new BufferedImage(bi.getWidth(),bi.getHeight(),BufferedImage.TYPE_INT_RGB);
        int x1 = 0;
        for (int y=0;y<bi.getHeight();y++){
            for (int x = bi.getWidth()-1;x >= 0;x--){
                newbi.setRGB(x1,y,bi.getRGB(x,y));
                x1++;
            }
        }
        ImageIO.write(newbi,"JPEG",new FileOutputStream("test.jpg"));
    }
    @Test
    public void test2() throws IOException {
        BufferedImage bi = ImageIO.read(new File("d://testtu.jpg"));
        System.out.println(Color.decode(bi.getRGB(50, 0)+"").toString());
        System.out.println(Color.decode(bi.getRGB(bi.getWidth()-1,bi.getHeight()-1)+"").toString());
    }
}
