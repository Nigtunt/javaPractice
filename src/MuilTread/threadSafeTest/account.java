package MuilTread.threadSafeTest;

/**
 * @Author: YHQ
 * @Date: 2019/11/16 16:59
 */
public class account {
    private int balance ;
    public account(){
        this.balance = 0;
    }
    public void depsoit(int money) {
        synchronized ("") {
            try {
                int newmoney = balance + money;
                Thread.sleep(100);
                this.balance =newmoney;


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public int getBalance(){
        return this.balance;
    }
}
