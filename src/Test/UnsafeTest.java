package Test;

import sun.misc.Unsafe;

/**
 * @Author: YHQ
 * @Date: 2020/3/25 19:43
 */
public class UnsafeTest {
    static int a = 10;
    static void t(){a--;}
    public static void main(String args[]){
        for (int i = 0; i < 2; i++) {
            new Thread(()->{
                t();
                System.out.println(Thread.currentThread().getName());
            }).start();
        }
    }
}
