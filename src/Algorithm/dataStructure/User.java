package Algorithm.dataStructure;

import java.io.Serializable;
import java.util.Objects;

/**
 * @Author: YHQ
 * @Date: 2019/11/10 10:47
 */
public class User implements Comparable<User>, Serializable {
    private int age;
    private String name;
    private int id;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User(int age, String name, int id) {
        this.age = age;
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public int compareTo(User o) {
        int x = this.age;
        int y = o.getAge();
        return Integer.compare(x,y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                id == user.id &&
                Objects.equals(name, user.name);
    }

}
