package reflectAndClass;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Stack;

class example {
    String s;
    int i,i2,i3;
    private example(){

    }
    protected example(String s,int i){
        this.s=s;
        this.i=i;
    }
    public example(String... strings) throws NumberFormatException{
        if(0<strings.length)
            i=Integer.valueOf(strings[0]);
        if(1<strings.length)
            i2=Integer.valueOf(strings[1]);
        if(2<strings.length)
            i3=Integer.valueOf(strings[2]);

    }
    public void print(){
        System.out.println("s="+s);
        System.out.println("i="+i);
        System.out.println("i2="+i2);
        System.out.println("i3="+i3);
    }
}
public class main_01 {
    public static void main(String args[]){
        example ex=new example("10","20","30");
        Class<? extends example> exC=ex.getClass();
        Constructor[] declaredConstructor =exC.getDeclaredConstructors();
        for (int i = 0; i < declaredConstructor.length; i++) {
            Constructor<?> constructor=declaredConstructor[i];
            System.out.println("查看是否允许带有可变数量的参数"+constructor.isVarArgs());
            System.out.println("该构造方法的入口参数类型依次是：");
            Class[] parameterTypes=constructor.getParameterTypes();
            for (int j = 0; j < parameterTypes.length; j++) {
                System.out.println(" "+parameterTypes[j]);
            }
            System.out.println("该构造方法可能抛出的异常类型为：");
            Class[] exceptionTypes =constructor.getExceptionTypes();
            for (int j = 0; j <exceptionTypes.length; j++) {
                System.out.println(" "+exceptionTypes[j]);
            }
            example ex2=null;
            while(ex2==null){
                try{
                    if(i==2)
                        ex2=(example)constructor.newInstance();
                    else if(i==1)
                        ex2=(example) constructor.newInstance("7",5);
                    else{
                        Object[] parameters =new Object[]{new String[]{"100","200","300"}} ;
                        ex2=(example) constructor.newInstance(parameters);
                    }
                } catch (Exception e){
                    System.out.println("创建时出现异常下面执行setAccessible()方法");
                    constructor.setAccessible(true);
//                    e.printStackTrace();
                }
            }
            if(ex2!=null){
                ex2.print();
                System.out.println();
            }
        }
    }
}
