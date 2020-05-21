package abstractClassAndInterface.simpleFactoryMode;

/**
 * @Author: YHQ
 * @Date: 2019/11/18 20:18
 */
public abstract class student {
    public static student create(){
        if(5-1>4){
            return new a();
        }else
            return new b();
    }
}
class a extends student{    //不同包无法访问，但可以从create()方法访问

}
class b extends student{

}
