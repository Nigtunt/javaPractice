package de;

/**
 * @Author: YHQ
 * @Date: 2020/5/13 14:43
 */
public class Student {
    private String name;
    private Book book;
    public Student(String name){
        this.name = name;
    }
    public void setBook(Book book){
        this.book = book;
    }
    public void read(){
        System.out.println(name+"正在读"+book.getName());
    }

    public static void main(String args[]){
        Book book1 = new Book("西游记");
        Book book2 = new Book("三国演义");
        Student stu = new Student("student");
        stu.setBook(book1);
        stu.read();
        stu.setBook(book2);
        stu.read();
    }
}
