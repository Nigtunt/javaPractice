package MuilTread;

import javax.swing.*;
import java.awt.*;

public class JoinTest extends  JFrame{
    private Thread threadA;
    private Thread threadB;
    final JProgressBar progressBar=new JProgressBar();
    final JProgressBar progressBar2=new JProgressBar();
    Container c=getContentPane();
    int count =0;
    public static void main(String args[]){
        init(new JoinTest(),100,100);
    }
    public JoinTest(){
        //super();
        c.add(progressBar,BorderLayout.NORTH);
        c.add(progressBar2,BorderLayout.SOUTH);
        progressBar.setStringPainted(true);
        progressBar2.setStringPainted(true);
        threadA=new Thread(new Runnable() {
            int count=0;
            @Override
            public void run() {
                while(true){
                    progressBar.setValue(++count);
                    try {
                        Thread.sleep(10);
                        threadB.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        threadA.start();
        threadB=new Thread(new Runnable() {
            int count=0;
            @Override
            public void run() {
                while(true){
                    progressBar2.setValue(++count);
                    try {
                        Thread.sleep(10);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(count==100) break;
                }
            }
        });
        threadB.start();

    }

    public static void init(JFrame jFrame,int width,int height){
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(width,height);
        jFrame.setVisible(true);
    }
}
