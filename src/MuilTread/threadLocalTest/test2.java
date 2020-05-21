package MuilTread.threadLocalTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @Author: YHQ
 * @Date: 2020/3/27 22:59
 */
public class test2 {
    public static void main(String args[]){
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        ThreadLocal<String> local = new InheritableThreadLocal<>();
        local.set("main1");
        executorService.submit(()->
            System.out.println("thread1get"+local.get())
        );
        local.set("main3");
        executorService.submit(()->{
            System.out.println(local.get());
            LockSupport.park();
            }
        );
        System.out.println("mainget"+local.get());
        try {
            executorService.shutdown();
            executorService.awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
