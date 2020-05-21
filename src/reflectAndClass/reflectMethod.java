package reflectAndClass;

import java.lang.reflect.Method;

class example3 {
    int kkk;
    static void staticMethod(){
        System.out.println("执行staticMethod（）方法");
    }
    public int publicMethod(int i) {
        System.out.println("执行publicMethod()方法");
        return i * 100;
    }

    protected int protectedMethod(String s, int i)
            throws NumberFormatException {
        System.out.println("执行protectedMethod()方法");
        return Integer.valueOf(s) + i;
    }

    private String privateMethod(String... strings) {
        System.out.println("执行privateMethod()方法");
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < strings.length; i++) {
            stringBuffer.append(strings[i]);
        }
        return stringBuffer.toString();
    }
}
public class reflectMethod {
    public static void main(String[] args) {
        example3 example = new example3();
        Class exampleC = example.getClass();

        // 获得所有方法
        Method[] declaredMethods = exampleC.getDeclaredMethods();
        for (int i = 0; i < declaredMethods.length; i++) {
            Method method = declaredMethods[i]; // 遍历方法
            System.out.println("名称为：" + method.getName()); // 获得方法名称
            System.out.println("是否允许带有可变数量的参数：" + method.isVarArgs());
            System.out.println("入口参数类型依次为：");
            // 获得所有参数类型
            Class[] parameterTypes = method.getParameterTypes();
            for (int j = 0; j < parameterTypes.length; j++) {
                System.out.println(" " + parameterTypes[j]);
            }
            // 获得方法返回值类型
            System.out.println("返回值类型为：" + method.getReturnType());
            System.out.println("可能抛出的异常类型有：");
            // 获得方法可能抛出的所有异常类型
            Class[] exceptionTypes = method.getExceptionTypes();
            for (int j = 0; j < exceptionTypes.length; j++) {
                System.out.println(" " + exceptionTypes[j]);
            }
            boolean isTurn = true;
            while (isTurn) {
                // 如果该方法的访问权限为private，则抛出异常，即不允许访问
                try {
                    isTurn = false;
                    if("staticMethod".equals(method.getName()))
                        method.invoke(example); // 执行没有入口参数的方法
                    else if("publicMethod".equals(method.getName()))
                        System.out.println("返回值为："
                                + method.invoke(example, 168)); // 执行方法
                    else if("protectedMethod".equals(method.getName()))
                        System.out.println("返回值为："
                                + method.invoke(example, "7", 5)); // 执行方法
                    else if("privateMethod".equals(method.getName())) {
                        Object[] parameters = new Object[] { new String[] {
                                "M", "W", "Q" } }; // 定义二维数组
                        System.out.println("返回值为："
                                + method.invoke(example, parameters));
                    }
                } catch (Exception e) {
                    System.out.println("在执行方法时抛出异常，"
                            + "下面执行setAccessible()方法！");
                    method.setAccessible(true); // 设置为允许访问
                    isTurn = true;
                }
            }
            System.out.println();
        }
    }
}
