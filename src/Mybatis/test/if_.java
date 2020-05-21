package Mybatis.test;

import Mybatis.pojo.Product;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: YHQ
 * @Date: 2020/2/13 13:54
 */
public class if_ {
    @Test
    public void test() throws IOException {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        InputStream inputStream = Resources.getResourceAsStream("Mybatis-cfg.xml");
        SqlSessionFactory factory = builder.build(inputStream);
        SqlSession session = factory.openSession();

        //List<Product> list = session.selectList("listProduct_IF");
        Map<String,Object> params = new HashMap<>();
        params.put("name","a");
        List<Product> list = session.selectList("listProduct_IF", params);
        for (Product p:list){
            System.out.println(p);
        }
    }

}
