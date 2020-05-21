package reflectAndClass;

import java.lang.reflect.Field;

class example2 extends  example3{
    int i;
    public float f;
    protected boolean b;
    private String s;

}
public class main_02 {
    public static void main(String args[]){
        example3 ex= new example2();
        Class exC=ex.getClass();
        Field[] declaredFields=exC.getDeclaredFields();
        for (int i = 0; i < declaredFields.length; i++) {
            Field field=declaredFields[i];
            System.out.println("名称为："+field.getName());
            Class fieldType=field.getType();
            System.out.println("类型为："+fieldType.getName());
            boolean isTurn=true;
            while(isTurn){
                try{
                    isTurn=false;
                    System.out.println("修改前的值为"+field.get(ex));
                    if(fieldType.getName().equals(int.class.getName())){
                        System.out.println("利用方法setint（）修改成员变量的值");
                        field.setInt(ex,168);

                    }else if(fieldType.equals(float.class)){
                        System.out.println("利用方法setFloat()修改成员变量的值");
                        field.setFloat(ex,99.9f);
                    }else if (fieldType.equals(boolean.class)){
                        System.out.println("利用方法setBoolean()修改成员变量的值");
                        field.setBoolean(ex,true);
                    }else{
                        System.out.println("利用方法set()修改成员变量的值");
                        field.set(ex,"MWQ");
                    }
                    System.out.println("修改后的值为"+field.get(ex));
                }catch (Exception e){
                    System.out.println("在设置成员变量的时候抛出异常，下面执行setAccessible()方法");
                    field.setAccessible(true);
                    isTurn=true;
                }
            }
        }
    }
}

