package MuilTread.CountDownLatchCyclicBarrierSemaphore;

import org.junit.Test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author: YHQ
 * @Date: 2020/3/26 18:38
 */
public class test2 {
    public int a = 10;
    public static void main(String args[]){
        CyclicBarrier barrier = new CyclicBarrier(4);
        for (int i = 0; i < 4; i++) {
            new Writer(barrier).start();
        }
//        CyclicBarrier barrier = new CyclicBarrier(4,()->{
//            System.out.println("当前线程"+Thread.currentThread().getName());
//            System.out.println("执行额外任务");
//        });
    }
    static class Writer extends Thread{
        private CyclicBarrier cyclicBarrier;
        public Writer(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println("线程"+Thread.currentThread().getName()+"正在写入数据...");
            try {
                Thread.sleep(3000+ (int) (Math.random() * 2000));      //以睡眠来模拟写入数据操作
                System.out.println("线程"+Thread.currentThread().getName()+"写入数据完毕，等待其他线程写入完毕");
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("所有线程写入完毕，继续处理其他任务...");
        }

    }
}
