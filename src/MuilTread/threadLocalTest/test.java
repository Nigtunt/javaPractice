package MuilTread.threadLocalTest;

/**
 * @Author: YHQ
 * @Date: 2020/3/27 22:48
 */
public class test {
    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
//        ThreadLocal<String> threadLocal = new InheritableThreadLocal<>();
        threadLocal.set("main thread");
        Thread thread = new Thread(()->{
            threadLocal.set("thread");
            // 直接使用ThreadLocal输出 null，使用ThreadLocal输出 main thread
            System.out.println(threadLocal.get());
        });
        threadLocal.set("main thread2");

        System.out.println(threadLocal.get());

        thread.start();
    }
}
