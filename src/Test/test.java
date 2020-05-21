package Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;
import java.util.TreeMap;

/**
 * @Author: YHQ
 * @Date: 2020/3/18 15:27
 */
public class test {
    private static test Instance = null;
    String s ;

    public test(){
        s = "test";
        System.out.println(Thread.currentThread().getName()+"构造");
    }
    public static test getInstance(){
        if (Instance==null){
            synchronized (test.class){
                if (Instance==null){
                    Instance = new test();
                }
            }
        }
        return Instance;
    }
    public static void main(String args[]) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                if (test.getInstance().s==null)
                    System.out.println("Test");
            }).start();
        }
    }
}
