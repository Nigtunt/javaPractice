package lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @Author: YHQ
 * @Date: 2019/11/22 18:18
 */
public class test {
    @Test
    public void test1(){
        Runnable r = ()->{
            while (true){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("13");
            }
        };
        r.run();
    }
    @Test
    public void test2(){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0;i<1000000;i++){
            list.add((int)(1+Math.random()*(10001)));
        }
        long start = System.currentTimeMillis();
        list.sort((o1, o2) -> {
            if (o1> o2) return -1;
            else if (o1< o2) return 1;
            return 0;
        });
        long end = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+" ");
        }
        System.out.println();
        System.out.println(end - start);
    }
}
