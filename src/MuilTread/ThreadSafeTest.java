package MuilTread;


import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeTest implements Runnable{
    private int num=100;
    static ReentrantLock lock = new ReentrantLock();
    @Override
    public void run(){
        while(true){
            lock.lock();
            if (num>0){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int temp = num;
                temp--;
                num = temp;
                System.out.println(Thread.currentThread().getName()+"tickets"+num);
                lock.unlock();
            }else{
                lock.unlock();
                break;
            }
        }
    }

    public static void main(String args[]){
        ThreadSafeTest t=  new ThreadSafeTest();
        Thread threadA=new Thread(t);
        Thread threadB=new Thread(t);
        Thread threadC=new Thread(t);
        Thread threadD=new Thread(t);
        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();
    }
    synchronized public void resr(){
    }
}
