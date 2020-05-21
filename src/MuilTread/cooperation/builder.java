package MuilTread.cooperation;

/**
 * @Author: YHQ
 * @Date: 2019/12/8 10:57
 */
public class builder extends Thread {
    private Pack pack;
    public builder(Pack pack){
        this.pack = pack;
    }
    @Override
    public void run() {
        while (true) {
            synchronized (pack) {
                if (pack.count <= 0) {
                    this.pack.count = 10;
                    System.out.println("做好10");
                    pack.notify();
                }
                else{
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

