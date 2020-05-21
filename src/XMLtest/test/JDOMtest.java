package XMLtest.test;


import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.*;

/**
 * @Author: YHQ
 * @Date: 2020/2/8 15:42
 */
public class JDOMtest {
    public static void main(String args[]) {
        Element students = new Element("students");

        Element student = new Element("student");
        student.setAttribute("id","1");
        Element name = new Element("name");
        name.setText("小民");
        Element age = new Element("age");
        age.setText("93");
        student.addContent(name).addContent(age);

        Element student2 = new Element("student");
        student2.setAttribute("id","2");
        Element name2 = new Element("name");
        name2.setText("小泽");
        Element age2 = new Element("age");
        age2.setText("13");
        student2.addContent(name2).addContent(age2);

        students.addContent(student).addContent(student2);
        Document document = new Document(students);
        XMLOutputter xml = new XMLOutputter();
        Format f = Format.getPrettyFormat();
        xml.setFormat(f);

        try {
            xml.output(document,new FileOutputStream("JDOM_student.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
