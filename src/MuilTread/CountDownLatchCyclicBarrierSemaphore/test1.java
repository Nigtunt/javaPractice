package MuilTread.CountDownLatchCyclicBarrierSemaphore;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @Author: YHQ
 * @Date: 2020/3/26 18:26
 */
public class test1 {
    public static void main(String args[]){
        CountDownLatch latch = new CountDownLatch(2);
        new Thread(()->{
           System.out.println("任务1"+Thread.currentThread().getName()+"正在执行");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("任务2"+Thread.currentThread().getName()+"正在完成");
            latch.countDown();
        }).start();
        new Thread(()->{
            System.out.println("任务2"+Thread.currentThread().getName()+"正在执行");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("任务2"+Thread.currentThread().getName()+"正在完成");
            latch.countDown();
        }).start();
        try {
            System.out.println("主进程等待，任务1、任务2");
            latch.await();
            System.out.println("2个子线程已经执行完毕");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
