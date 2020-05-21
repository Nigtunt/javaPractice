package MuilTread.cooperation;

/**
 * @Author: YHQ
 * @Date: 2019/12/9 23:32
 */
public class Task {
    public static void execute(){
        Long start = System.currentTimeMillis();
        while (true){
            if ((System.currentTimeMillis()-start) < 1 ){
                System.out.println(Thread.currentThread().getName()+"执行读操作");
            }else {
                System.out.println(Thread.currentThread().getName()+"结束执行读操作");
                break;
            }
        }
    }
}
