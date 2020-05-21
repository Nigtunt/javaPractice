package Mybatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import Mybatis.mapper.categoryMapper;
import Mybatis.pojo.category;
/**
 * @Author: YHQ
 * @Date: 2020/2/14 12:08
 */
public class 注释 {
    @Test
    public void test() throws IOException {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        InputStream inputStream = Resources.getResourceAsStream("Mybatis-cfg.xml");

        SqlSessionFactory factory = builder.build(inputStream);
        SqlSession session = factory.openSession();
        categoryMapper mapper = session.getMapper(categoryMapper.class);

        category c = new category();
        c.setName("注释添加");
        mapper.add(c);
        list(mapper);

        mapper.delete(2);
        list(mapper);

        category c2 = new category();
        c2.setName("category changed");
        c2.setId(5);
        mapper.update(c2);
        list(mapper);

        category category = mapper.get(8);
        System.out.println(category.getId()+":"+category.getName());
        session.commit();
        session.close();

    }
    private void list(categoryMapper m){
        List<category> list = m.list();
        for (category c: list){
            System.out.println(c.getId()+":"+c.getName());
        }
    }

}
