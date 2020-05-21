package MuilTread;

import javax.swing.*;
import java.awt.*;

public class PriorityTest extends JFrame{
    private Thread threadA;
    private Thread threadB;
    private Thread threadC;
    private Thread threadD;
    private JProgressBar progressBar1;
    private JProgressBar progressBar2;
    private JProgressBar progressBar3;
    private JProgressBar progressBar4;

        public PriorityTest(){
            super();
            progressBar1=new JProgressBar();
            progressBar2=new JProgressBar();
            progressBar3=new JProgressBar();
            progressBar4=new JProgressBar();
            progressBar1.setStringPainted(true);
            progressBar2.setStringPainted(true);
            progressBar3.setStringPainted(true);
            progressBar4.setStringPainted(true);
            setLayout(new FlowLayout());
            getContentPane().add(progressBar1);
            getContentPane().add(progressBar2);
            getContentPane().add(progressBar3);
            getContentPane().add(progressBar4);
            threadA=new Thread(new MyThread(progressBar1));
            threadB=new Thread(new MyThread(progressBar2));
            threadC=new Thread(new MyThread(progressBar3));
            threadD=new Thread(new MyThread(progressBar4));
            setPriority("threadA",5,threadA);
            setPriority("threadB",5,threadB);
            setPriority("threadC",4,threadC);
            setPriority("threadD",3,threadD);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(200,200);
            setVisible(true);
        }
        public static void main(String args[]){
            new PriorityTest();
        }
    public static void setPriority(String ThreadName,int priority,Thread t){
            t.setPriority(priority);
            t.setName(ThreadName);
            t.start();
    }
        private final class MyThread implements Runnable{
            private final JProgressBar bar;
            int count=0;

            private MyThread(JProgressBar bar){
                this.bar=bar;
            }
            @Override
            public void run() {
                while(true){
                    bar.setValue(count+=10);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println("进程被中断");
                    }
                }
            }
        }
}
