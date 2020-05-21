package MuilTread.cooperation;

/**
 * @Author: YHQ
 * @Date: 2019/12/8 11:01
 */
public class customer extends Thread{
    private Pack pack;
    public customer(Pack pack){
        this.pack = pack;
    }
    public void run(){
        while (true){
            synchronized (pack){
                if (this.pack.count>0){
                    System.out.println(this.getName()+"吃了"+pack.count--);
                }else {
                    pack.notifyAll();
                    try {
                        pack.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
