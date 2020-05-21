package MuilTread;

import javax.swing.*;
import java.awt.*;

public class InterrputedSwing extends JFrame {
    Thread thread;
    public InterrputedSwing(){
        super();
        final JProgressBar progressBar=new JProgressBar();
        getContentPane().add(progressBar, BorderLayout.NORTH);
        thread=new Thread(new Runnable() {
            int count=0;
            @Override
            public void run() {
                while(true){
                    progressBar.setValue(++count);
                    try {
                        thread.sleep(10);
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("程序被中断");
                        break;
                    }
                }
            }
        });
        thread.start();
        thread.interrupt();
    }
    public static void main(String args[]){
        InterrputedSwing i=new InterrputedSwing();
        i.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        i.setSize(100,100);
        i.setVisible(true);
    }
}
