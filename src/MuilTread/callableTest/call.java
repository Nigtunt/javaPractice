package MuilTread.callableTest;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author: YHQ
 * @Date: 2020/3/23 16:28
 */
public class call implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("this is call test");
        Thread.sleep(500);
        return "success";
    }
    public static void main(String args[]){
        FutureTask<String> f = new FutureTask<String>(new call());
        new Thread(f).start();

        try {

            String s = f.get();
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
