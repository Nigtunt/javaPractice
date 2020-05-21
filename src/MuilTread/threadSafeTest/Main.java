package MuilTread.threadSafeTest;

/**
 * @Author: YHQ
 * @Date: 2019/11/16 17:05
 */
public class Main {
    public static void main(String args[]){
        account a = new account();
        Thread [] threads = new Thread[100];
        for (int i = 0; i < 100; i++) {
            threads[i] =new Thread(new addMoneyThread(a,1)) ;
            threads[i].start();
        }
        for (int i = 0; i < 100; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(a.getBalance());
    }
}
