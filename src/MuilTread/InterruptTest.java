package MuilTread;

import org.junit.Test;

/**
 * @Author: YHQ
 * @Date: 2019/12/8 16:24
 */
public class InterruptTest {
    public static void main(String args[]){
        Thread t = new Thread(new work());
        t.start();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.interrupt();
        System.out.println("main thread stopped");
    }
    public static class work implements Runnable{
        @Override
        public void run() {
            System.out.println("working start");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("work isinterrupted:"+
                        Thread.currentThread().isInterrupted());
                Thread curr = Thread.currentThread();

                //再次调用interrupt方法中断自己，将中断状态设置为“中断”
                curr.interrupt();
                System.out.println("work IsInterrupted: " + curr.isInterrupted());
                System.out.println("work IsInterrupted: " + curr.isInterrupted());
                System.out.println("Static Call: " + Thread.interrupted());//clear status
                System.out.println("---------After Interrupt Status Cleared----------");
                System.out.println("work IsInterrupted: " + curr.isInterrupted());
                System.out.println("work IsInterrupted: " + curr.isInterrupted());

            }

        }
        @Test
        public void test(){
            System.out.println("work stopped");
            String s = "A man, a plan, a canal: Panama1";
            s = s.toUpperCase();
            s = s.replaceAll("[^A-Z|0-9]","");
            for(int i=0,j=s.length()-1;i<j;i++,j--){
                if (s.charAt(i)!=s.charAt(j)){
                    System.out.println("s");
                    break;
                }
            }
        }
    }
}
