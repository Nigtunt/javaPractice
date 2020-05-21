package Mybatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Mybatis.pojo.*;
/**
 * @Author: YHQ
 * @Date: 2020/2/10 16:05
 */
public class test {
    @Test
    public void test() throws Exception{
        String resource = "Mybatis-cfg.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session=sqlSessionFactory.openSession();

        List<category> cs= session.selectList("listCategory");
        for (category c : cs) {
            System.out.println(c.getId()+":"+c.getName());
        }
    }

    /**
     * 增
     * @throws Exception
     */
    @Test
    public void test2() throws Exception{

        InputStream resource = Resources.getResourceAsStream("Mybatis-cfg.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resource);
        SqlSession Session = factory.openSession();

        for (int i = 0; i < 10; i++) {
            category c = new category();
            c.setName("category"+(i+1));
            Session.insert("insertCategory",c);
        }

        Session.commit();
        Session.close();
    }

    /**
     * 更新
     * @throws Exception
     */
    @Test
    public void test3() throws Exception{
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(new FileInputStream("src/Mybatis-cfg.xml"));
        SqlSession session = factory.openSession();

        category c  = session.selectOne("getCategory",3);
        c.setName("update category3 name");
        session.update("updateCategory", c);
        session.commit();
        session.close();
    }
    /**
     *  模糊查询
     */
    @Test
    public void test4() throws Exception{
        InputStream resource = Resources.getResourceAsStream("Mybatis-cfg.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resource);
        SqlSession session = factory.openSession();

        Map<String,Object> params = new HashMap<>();

        params.put("name",6);
        List<category> cs = session.selectList("listCategoryByName",params);
        for (category c : cs) {
            System.out.println(c.getName());
        }

        session.commit();
        session.close();
    }
    /**
     * 多条件查询
     */
    @Test
    public void test5() throws Exception{
        InputStream resource = Resources.getResourceAsStream("Mybatis-cfg.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resource);
        SqlSession session = factory.openSession();

        Map<String,Object> params = new HashMap<>();
        params.put("id", 8);
        params.put("name", "cat");
        List<category> list = session.selectList("listCategoryByIdAndName", params);

        for (category c : list){
            System.out.println(c.getId()+":"+c.getName());
        }
        session.close();
    }
    /**
     * 一对多
     */
    @Test
    public void test6() throws IOException {
        String resource = "Mybatis-cfg.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();

        List<category> cs = session.selectList("listCategory2");
        for (category c : cs) {
            System.out.println(c);
            List<Product> ps = c.getProducts();
            for (Product p : ps) {
                System.out.println("\t"+p);
            }
        }

        session.commit();
        session.close();
    }
    /**
     * 多对一
     */
    @Test
    public void test7() throws IOException{
        String resource = "Mybatis-cfg.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();

        List<Product> ps = session.selectList("listProduct");
        for (Product p : ps) {
            System.out.println(p+" 对应的分类是 \t "+ p.getCategory());
        }

        session.commit();
        session.close();
    }

    /**
     * 更新id等于5的product的分类为category2
     */
    @Test
    public void test8() throws IOException{
        String resource = "Mybatis-cfg.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();

        Product p = session.selectOne("getProduct",5);

        category c = session.selectOne("getCategory",1);
        p.setCategory(c);
        session.update("updateProduct",p);

        session.commit();
        session.close();
    }
}
