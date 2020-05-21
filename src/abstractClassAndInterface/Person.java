package abstractClassAndInterface;

import java.awt.event.ActionListener;
import java.util.Collections;

/**
 * @Author: YHQ
 * @Date: 2019/11/9 19:15
 */
public abstract class Person {   //抽象类不能实例化
    private int i;
    private String name;

    public Person(int i, String name) {
        this.i = i;
        this.name = name;
    }

    public void eat(Food food){
        System.out.println(this.name + "吃"+food.getName());
    }
    public abstract void work();
    public static void main(String args[]){
        Person person = new student(1,"张三");
        person.eat(new steak());
        person.eat(new 鸡());
        person.work();
    }

}
abstract class Food{
    private String name;

    public Food(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
class 鸡 extends Food{
    public 鸡() {
        super("鸡");
    }
}
class steak extends Food{

    public steak() {
        super("steak");
    }
}
class student extends Person{

    public student(int i, String name) {
        super(i, name);
    }

    @Override
    public void work() {
        System.out.println("学习");
    }
}