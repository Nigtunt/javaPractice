package MuilTread;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class SleepMethodTest extends JFrame {
    private Thread t;
    private static Color[] colors={Color.BLACK,Color.BLUE,Color.CYAN,Color.GREEN,Color.ORANGE,
        Color.YELLOW,Color.RED,Color.PINK,Color.LIGHT_GRAY};
    public static final Random rand=new Random();
    private static Color getC(){
        return colors[rand.nextInt(colors.length)];
    }
     public SleepMethodTest(){
        t=new Thread(new Runnable() {
            int x=400;
            int y=100;
            @Override
            public void run() {
                while(true){
                    try {
                        Thread.sleep(110);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Graphics graphics=getGraphics();
                    graphics.setColor(getC());

                    graphics.drawLine(x,y,100,y+=10);
                    if (y>400){
                        y=100;
                    }
                }
            }
        });
        t.start();
     }
     public static void main(String args[]){
        SleepMethodTest s=new SleepMethodTest();
        s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        s.setSize(500,500);
        s.setVisible(true);
        s.setLocation(500,250);
    }

}
