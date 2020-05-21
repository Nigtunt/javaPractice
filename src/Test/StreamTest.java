package Test;

import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: YHQ
 * @Date: 2020/3/25 12:19
 */
public class StreamTest {
    @Test
    public void test1(){
        Collection<String> list = Arrays.asList("Jzm","Mzd","Dxp","Hjt","Xjp");
        Stream<String> z = list.stream()
                .filter(s -> s.contains("z"))
                .sorted()
                .map(String::toUpperCase);
        Object[] objects = z.toArray();
        for (Object object : objects) {
            System.out.println(object);
        }
    }
    @Test
    public void test2() throws IOException {
        Path test = Path.of("d://test.html");
        List<String> pan = Files.lines(test).filter(s -> s.contains("pan"))
                .collect(Collectors.toList());
        HashMap<String,String> map = new HashMap<>();
        for (int i = 0; i < 50; i++) {
            map.put("test"+i,"test");
        }
        System.out.println(new Object().hashCode());
        System.out.println(new Object().hashCode());
    }
    @Test
    public void test3(){
        Collection<String> list = Arrays.asList("Jzm","Mzd","Dxp","Hjt","Xjp");
        Predicate<String> p = s -> s.contains("z");   //谓词逻辑
        Stream<String> z = list.stream()
                .filter(p)
                .sorted()
                .map(String::toUpperCase);
    }
    @Test
    public void test4(){
        String s1 = "hello";
        String s2 = "world";
        Collection<String> list = Arrays.asList(s1,s2);
        list.stream().map(s-> Arrays.stream(s.split(""))).forEach(System.out::println);
        Collection<String> list2 = Arrays.asList("hello","world");
        list.stream().flatMap(s-> Arrays.stream(s.split(""))).forEach(System.out::println);
    }
    interface a{
        private void test(){

        }
        void fesf();
        default int vs(){
            return 1;
        }
    }
    class person{
        private int age;
        private String name;
        public person(int age,String name){
            this.age= age;
            this.name=name;
        }

        @Override
        public String toString() {
            return "person{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
    @Test
    public void test5(){
        List<person> list = new ArrayList<>();
        list.add(new person(15,"fesf"));
        list.add(new person(145,"sfsgd"));
        list.add(new person(1455,"rdgdfrdrgf"));
        list.add(new person(454,"grdgfesf"));
        list.add(new person(45,"grdgfesf"));
        list.add(new person(55,"cfgesfesf"));
        list.add(new person(5,"gsgfesf"));
        list.sort(
                Comparator.comparing(person::getName)
                .thenComparingInt(person::getAge)
        );
        System.out.println(list);
    }
}
