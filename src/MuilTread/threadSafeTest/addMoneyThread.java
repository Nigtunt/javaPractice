package MuilTread.threadSafeTest;

/**
 * @Author: YHQ
 * @Date: 2019/11/16 17:03
 */
public class addMoneyThread implements Runnable {
    private account acc;
    private int money;
    public addMoneyThread(account acc, int money) {
        this.acc = acc;
        this.money = money;
    }


    @Override
    public void run() {
        acc.depsoit(money);
    }
}
