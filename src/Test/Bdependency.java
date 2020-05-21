package Test;

/**
 * @Author: YHQ
 * @Date: 2020/5/8 17:30
 */
public class Bdependency {
    private A a;
    //整体-部分
    public Bdependency(){
        this.a = new A();
    }
    //整体-个体
    public void setA(A a){
        this.a = a ;
    }
    //消息连接
    public void method1(A a){
        a.aa();
    }
}
