package reflectAndClass;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Target(ElementType.CONSTRUCTOR)
@Retention(RetentionPolicy.RUNTIME)
@interface Construction_Annotaion{
    String value() default "默认构造方法";
}
@Target({ElementType.FIELD,ElementType.METHOD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@interface Field_Method_Parameter_Annotation{
    String describle();
    Class type() default void.class;

}
public class Annotation {
    @Field_Method_Parameter_Annotation(describle = "编号",type = int.class)
    int id;
    @Field_Method_Parameter_Annotation(describle = "姓名" ,type = String.class)
    String name;
    @Construction_Annotaion()
    public Annotation(){ }
    @Construction_Annotaion("立即初始化")
    private Annotation(@Field_Method_Parameter_Annotation(describle = "编号",type = int.class)
                                   int id,
                       @Field_Method_Parameter_Annotation(describle = "姓名" ,type = String.class)
                               String name){
        this.id=id;
        this.name=name;
    }
    @Field_Method_Parameter_Annotation(describle = "获得id",type = int.class)
    public int getId(){
        return id;
    }
    @Field_Method_Parameter_Annotation(describle = "设置id")
    public void setId(@Field_Method_Parameter_Annotation(describle = "编号",type = int.class)
                      int id){
        this.id=id;
    }
    @Field_Method_Parameter_Annotation(describle = "获得name",type = String.class)
    public String getName(){
        return name;
    }
    @Field_Method_Parameter_Annotation(describle = "设置name",type = String.class)
    public void setName(@Field_Method_Parameter_Annotation(describle = "姓名",type = int.class)
                        String name){
        this.name=name;
    }

}
