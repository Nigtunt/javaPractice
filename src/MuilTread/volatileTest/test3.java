package MuilTread.volatileTest;

import java.util.concurrent.TimeUnit;

/**
 * @Author: YHQ
 * @Date: 2020/3/26 17:54
 */
public class test3{
    public synchronized void test1(){
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+":"+i);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void test2(){
        synchronized (test3.class) {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName()+":"+i);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String args[]){
        test3 t= new test3();
        test3 t2 = new test3();
        new Thread(t::test1).start();
        new Thread(t2::test1).start();

    }

}
