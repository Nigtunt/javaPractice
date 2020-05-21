package MuilTread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author: YHQ
 * @Date: 2019/12/8 9:39
 */
public class runTest implements Runnable {
    private int time;
    ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        time = 5;
        do{
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" "+time--);
        }while (time>=0);
    }
    public static void main(String args[]) throws InterruptedException{
        runTest runTest1 = new runTest();
        runTest runTest2 = new runTest();
        Thread t1 = new Thread(runTest1);
        Thread t2 = new Thread(runTest2);
        t1.start();
//        t2.start();
//        t1.join();
        t1.interrupt();
    }
}
