package hibernate.pojo;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: YHQ
 * @Date: 2020/1/7 22:52
 */
public class test {
    @Test
    public void test(){
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session s = sf.openSession();
        s.beginTransaction();

        for (int i = 0; i < 10; i++) {
            Product p = new Product();
            p.setName("iphone"+i);
            p.setPrice(i);
            s.save(p);
        }
        s.getTransaction().commit();
        s.close();
        sf.close();
    }
    @Test
    public void test1(){
        SessionFactory sf = new Configuration().configure().buildSessionFactory();

        Session s = sf.openSession();
        s.beginTransaction();

        Query q = s.createQuery("from Product p where p.name like ?");
        q.setString(0,"%iphone%");

        List<Product> list = q.list();
        for (Product pp:list){
            System.out.println(pp.getName());
        }
        s.getTransaction().commit();
        s.close();
        sf.close();
    }

    @Test
    public void test2(){
        SessionFactory sf = new Configuration().configure().buildSessionFactory();

        Session s = sf.openSession();
        s.beginTransaction();

//        Criteria c = s.createCriteria(Product.class);
//        c.add(Restrictions.like("name","%iphone%"));
//        List<Product> list = c.list();
//        for (Product product:list)
//            System.out.println(product.getName()+":" +product.getPrice());

        Product p = (Product) s.get(Product.class,6);

        System.out.println(p.getCategory().getName());
        s.getTransaction().commit();
        s.close();
        sf.close();
    }

    @Test
    public void test3(){
        SessionFactory sf = new Configuration().configure().buildSessionFactory();

        Session s = sf.openSession();
        s.beginTransaction();

        Category c =(Category) s.get(Category.class,1);


        Product p = (Product) s.get(Product.class, 6);
        p.setCategory(c);
        s.update(p);

        s.getTransaction().commit();
        s.close();
        sf.close();
    }

    @Test
    public void test5(){
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session s = sf.openSession();
        s.beginTransaction();

        Category c = (Category) s.get(Category.class, 1);
        Set<Product> ps = c.getProducts();
        for (Product p : ps) {
            System.out.println(p.getName());
        }

        s.getTransaction().commit();
        s.close();
        sf.close();
    }

    /**
     * 多对多
     */
    @Test
    public void test6(){
        SessionFactory sf = new Configuration().configure().buildSessionFactory();

        Session s = sf.openSession();
        s.beginTransaction();

        //增加3个用户
        Set<User> users = new HashSet<>();
        for (int i = 1; i <= 3; i++) {
            User u = (User) s.get(User.class,i);
            users.add(u);
        }

        //产品1被用户1,2,3购买
        Product p1 = (Product) s.get(Product.class, 2);

        p1.setUsers(users);
        s.update(p1);
        s.getTransaction().commit();
        s.close();
        sf.close();
    }
    /**
     * 事务
     */
    @Test
    public void test7(){
        Configuration conf = new Configuration();
        SessionFactory sf = conf.configure().buildSessionFactory();
        Session s = sf.openSession();
        s.beginTransaction();

        Product p1 = (Product) s.get(Product.class,7);
        p1.setName("iphone6");
        s.update(p1);

        Product p = (Product) s.get(Product.class,1);
        s.delete(p);



        s.getTransaction().commit();

        s.close();
        sf.close();
    }

    /**
     * 属性延迟显示
     * 当使用load的方式来获取对象的时候，只有访问了这个对象的属性，
     * hibernate才会到数据库中进行查询。否则不会访问数据库
     */
    @Test
    public void test8(){
        Configuration conf = new Configuration();
        SessionFactory sf = conf.configure().buildSessionFactory();
        Session s = sf.openSession();
        s.beginTransaction();

        Product p = (Product) s.load(Product.class,2);
        System.out.println("log1");
        System.out.println(p.getName());
        System.out.println("log2");
        s.getTransaction().commit();

        s.close();
        sf.close();
    }

    /**
     *one-many many-many的时候都可以使用关系的延迟加载
     *
     */
    @Test
    public void test9(){
        Configuration conf = new Configuration();
        SessionFactory sf = conf.configure().buildSessionFactory();
        Session s = sf.openSession();
        s.beginTransaction();

        Product p =(Product) s.get(Product.class,2);

        System.out.println("log1");
        System.out.println(p.getUsers().size());
        System.out.println("log2");

        s.getTransaction().commit();
        s.close();
        sf.close();
    }

    /**
     * 第一次通过id=1获取对象的时候，session中是没有对应缓存对象的，所以会在"log1"后出现sql查询语句。
     * 第二次通过id=1获取对象的时候，session中有对应的缓存对象，所以在"log2"后不会出现sql查询语句
     */
    @Test
    public void test10(){
        Configuration conf = new Configuration();
        SessionFactory sf = conf.configure().buildSessionFactory();
        Session s = sf.openSession();
        s.beginTransaction();

        System.out.println("log1");
        Category c = (Category) s.get(Category.class,1);
        System.out.println("log1");
        Category ca = (Category) s.get(Category.class,1);
        System.out.println("log1");

        s.getTransaction().commit();
        s.close();
        sf.close();
    }
    /**
     * 分页查询
     */
    @Test
    public void test11(){
        long start = System.currentTimeMillis();
        Configuration conf = new Configuration();
        SessionFactory sf = conf.configure().buildSessionFactory();
        Session s = sf.openSession();
        s.beginTransaction();

        Criteria c = s.createCriteria(Product.class);
        c.add(Restrictions.like("name","%iphone%"));
        c.setFirstResult(2);
        c.setMaxResults(3);

        List<Product> ps = c.list();
        for (Product p : ps) {
            System.out.println(p.getName());

        }

        s.getTransaction().commit();
        s.close();
        sf.close();
        System.out.println(System.currentTimeMillis() - start);
    }
    /**
     * Hibernate有两种方式获得session,分别是：
     * openSession和getCurrentSession
     * 他们的区别在于
     * 1. 获取的是否是同一个session对象
     * openSession每次都会得到一个新的Session对象
     * getCurrentSession在同一个线程中，每次都是获取相同的Session对象，但是在不同的线程中获取的是不同的Session对象
     * 2. 事务提交的必要性
     * openSession只有在增加，删除，修改的时候需要事务，查询时不需要的
     * getCurrentSession是所有操作都必须放在事务中进行，并且提交事务后，session就自动关闭，不能够再进行关闭
     */

    /**
     * 查询总数
     */
    @Test
    public void test12(){
        Configuration conf = new Configuration();
        SessionFactory sf = conf.configure().buildSessionFactory();
        Session s = sf.openSession();
        s.beginTransaction();

        Query q = s.createSQLQuery("select count(*) from product_ where name like ?");
        q.setString(0,"%iphone%");
        System.out.println(q.uniqueResult().getClass().getName());
    }
    /**
     * 乐观锁
     */
    @Test
    public void test13(){
        Configuration conf = new Configuration();
        SessionFactory sf = conf.configure().buildSessionFactory();
        Session s1 = sf.openSession();
        Session s2 = sf.openSession();
        s1.beginTransaction();
        s2.beginTransaction();

        Product p1 = (Product) s1.get(Product.class,2);
        System.out.println("原价："+p1.getPrice());
        p1.setPrice(p1.getPrice()+100);

        Product p2 = (Product) s2.get(Product.class,2);
        p2.setPrice(p2.getPrice()+100);

        s1.update(p1);
        s2.update(p2);

        s1.getTransaction().commit();
        s2.getTransaction().commit();

        Product p = (Product) s1.get(Product.class, 2);

        System.out.println("经过两次价格增加后，价格变为: " + p.getPrice());

        s1.close();
        s2.close();

        sf.close();
    }
}
