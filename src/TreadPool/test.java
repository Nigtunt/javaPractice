package TreadPool;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.*;

/**
 * @Author: YHQ
 * @Date: 2020/3/7 13:21
 */
public class test {
    void test1(){
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 20; i++) {
            executorService.submit(()->{
                for (int i1 = 0; i1 < 100; i1++) {
                    System.out.println(Thread.currentThread().getName()+":"+i1);
                }
            });
        }
        executorService.shutdown();
    }
    void test2(){
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        scheduledExecutorService.schedule(()->{
            for (int i=0;i<100;i++){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        },3,TimeUnit.SECONDS);
    }
    void test4(){
        ArrayList<Integer> list = new ArrayList<>();
        Random r = new Random();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            Thread t = new Thread(()->{
                list.add(r.nextInt());
            });
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(list.size());
    }

    public static void main(String args[]) throws InterruptedException {
//        long start = System.currentTimeMillis();
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        ArrayList<Integer> list = new ArrayList<>();
//        Random r = new Random();
//        for (int i = 0; i < 10000; i++) {
//            executorService.submit(()->{
//                list.add(r.nextInt());
//            });
//        }
//        executorService.shutdown();
//        executorService.awaitTermination(1,TimeUnit.SECONDS);
//        System.out.println(list.size());
//        System.out.println(System.currentTimeMillis() - start);
        ExecutorService executorService = Executors.newFixedThreadPool(1000);

        for (int i = 0; i < 2000000000; i++) {
            final int x = i;
            executorService.submit(()->{
                System.out.println(Thread.currentThread().getName()+":"+x);

            });
        }
        executorService.shutdown();
        executorService.awaitTermination(10,TimeUnit.SECONDS);
    }
}
