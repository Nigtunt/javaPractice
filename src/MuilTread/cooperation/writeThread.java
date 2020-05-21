package MuilTread.cooperation;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author: YHQ
 * @Date: 2019/12/9 23:38
 */
public class writeThread extends Thread {
    private ReentrantReadWriteLock rw = null;
    public writeThread(ReentrantReadWriteLock rw){
        this.rw = rw;
    }

    public void run(){
        rw.writeLock().lock();
        for (int i=0;i<5;i++){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"正在进行写操作");
        }
        rw.writeLock().unlock();
    }
}
