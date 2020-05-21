package Test;

import java.lang.annotation.*;

/**
 * @Author: YHQ
 * @Date: 2019/12/24 12:44
 */
@Target({ElementType.METHOD,ElementType.TYPE})   //可以给谁注释
@Retention(RetentionPolicy.RUNTIME)     //注释在运行时依然存在   SOURCE是编译后消失
                                        //CLASS 编译后存在  运行后消失
@Inherited                          //表示该注解具有继承性
@Documented                         //在用javadoc命令生成API文档后，DBUtil的文档里会出现该注解说明。
public @interface JDBCConfig {
    String ip();
    int port() default 3306;
    String database();
    String encoding();
    String loginName();
    String password();
}
