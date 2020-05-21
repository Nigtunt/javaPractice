package de;

/**
 * @Author: YHQ
 * @Date: 2020/5/21 15:51
 */
public class Teacher {
    private Book book;

    public void teach(){
        System.out.println("teacher is teaching "+book.getName());
    }
}
