package de;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: YHQ
 * @Date: 2020/5/21 15:38
 */
public class Class {
    private List<Student> students ;
    private List<Teacher> teachers;
    public Class(){
        students = new ArrayList<>();
        teachers = new ArrayList<>();
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public void removeStudent(Student student){
        students.remove(student);
    }
    public void addTeacher(Teacher teacher){
        teachers.add(teacher);
    }

    public void removeTeacher(Teacher teacher){
        teachers.remove(teacher);
    }
}
