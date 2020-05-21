package enumAndGenerics;




interface Constant{
    public static final int Constants_a=1;
    public static final int Constants_b=12;

}

public class example{
    enum Constants{
        Constants_a,Constants_b;
    }
    public static void doit(int c){
        switch (c){
            case Constant.Constants_a:
                System.out.println("doit()Constants_a");
                break;
                case Constant.Constants_b:
                    System.out.println("doit()Constants_b");
                    break;

        }
    }
    public static void doit2(Constants c) {
        switch (c) { // 根据枚举类型对象做不同操作
            case Constants_a:
                System.out.println("doit2() Constants_a");
                break;
            case Constants_b:
                System.out.println("doit2() Constants_b");
                break;
        }
    }
    public static void main(String[] args) {
        example.doit(Constant.Constants_a); // 使用接口中定义的常量
        example.doit2(Constants.Constants_a); // 使用枚举类型中的常量
        example.doit2(Constants.Constants_b); // 使用枚举类型中的常量
        example.doit(3);
        // ConstantsTest.doit2(3);
        for (int i = 0; i < Constants.values().length; i++) {
            System.out.println("枚举类型成员变量："+Constants.values()[i]);
        }
        for (int i = 0; i < Constants.values().length; i++) {
            System.out.println(Constants.values()[i]+"位置引索值为："+Constants.values()[i].ordinal());
        }
    }
}
