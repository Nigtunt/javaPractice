package MuilTread.volatileTest;

/**
 * @Author: YHQ
 * @Date: 2020/3/25 17:57
 */
public class test2 {
    static class MyData {
        //int number = 0; // 没加volatile关键字
         Integer number = 1;
         void addPlusPlus() {
            this.number++;
        }
    }

    // 验证volatile不保证原子性
    public static void main(String[] args) {
        MyData mydata2 = new MyData();
        for(int i = 0; i < 20; i ++ ) { // 创建20个线程
            new Thread("线程" + i) {
                public void run() {
                    try {
                        for(int j = 0; j < 1000; j++) {
                            mydata2.addPlusPlus();// 每个线程执行1000次number++
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                };
            }.start();
        }
        // 保证上面的线程执行完main线程再输出结果。 大于2，因为默认有main线程和gc线程
        while(Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.err.println(Thread.currentThread().getName() + " obtain the number is " + mydata2.number);
    }
}
