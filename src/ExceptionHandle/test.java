package ExceptionHandle;

/**
 * @Author: YHQ
 * @Date: 2019/11/29 19:17
 */
public class test {
    public static void test1(){
        test2();
    }
    public static void test2(){
        test3();
    }
    public static void test3(){
        test4();
    }
    public static void test4(){
        test5();
    }
    public static void test5(){
        test6();
    }
    public static void test6() {
        if (1==1)
            throw new RuntimeException("异常");
    }
    public static void main(String args[]){
        test1();
    }
}
