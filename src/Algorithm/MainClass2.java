package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: YHQ
 * @Date: 2019/11/3 20:07
 */
class Student{
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
public class MainClass2 {
    private static Student binarySearch(ArrayList list,int start,int end,int id){
        if (start>end) return null;
        Student s = (Student)list.get((start + end)/2);
        if(s.getId() < id){
            s = binarySearch(list,(start + end)/2 + 1 ,end,id);
        }else if(s.getId() > id){
            s = binarySearch(list,start,(start + end)/2 - 1,id);
        }
        return s;
    }

    private static Student search(int id,ArrayList list){
        return binarySearch(list,0,list.size() - 1,id);
    }

    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        Student s = new Student();
        s.setId(1111);
        s.setName("张三");
        list.add(s);
        s = new Student();
        s.setId(1112);
        s.setName("李四");
        list.add(s);
        s = new Student();
        s.setId(1113);
        s.setName("王麻子");
        list.add(s);
        s = new Student();
        s.setId(1114);
        s.setName("赵六");
        list.add(s);
        s = new Student();
        s.setId(1115);
        s.setName("候七");
        list.add(s);
        int id = 1116;//我们要查找的学生的id
        Student s1 = search(id,list);
        if(s1!=null)
            System.out.println(s1.getId() + ":" + s1.getName());
//        for(int i = 0 ; i < list.size() ; i++){
//            if(((Student)list.get(i)).getId() == id){
//                Student ss = (Student)list.get(i);
//                System.out.println(ss.getName() + ":" + ss.getId());
//                break;
//            }
//        }
    }
}

