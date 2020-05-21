package Mybatis.test;

import Mybatis.pojo.Order;
import Mybatis.pojo.OrderItem;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @Author: YHQ
 * @Date: 2020/2/13 13:22
 */
public class ManyToMany {
    @Test
    public void test() throws IOException {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        InputStream inputStream = Resources.getResourceAsStream("Mybatis-cfg.xml");
        SqlSessionFactory factory = builder.build(inputStream);
        SqlSession session = factory.openSession();

        List<Order> list = session.selectList("listOrder");

        for (Order o:list){
            System.out.println(o.getId()+o.getCode());
            for (OrderItem s:o.getOrderItems()){
                System.out.println("\t"+s.getId());
                System.out.println("\t"+s.getNumber());
                System.out.println("\t"+s.getOrder());
                System.out.println("\t\t"+s.getProduct().getId());
                System.out.println("\t\t"+s.getProduct().getName());
                System.out.println("\t\t"+s.getProduct().getPrice());
            }
        }
    }
}
