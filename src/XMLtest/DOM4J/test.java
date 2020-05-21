package XMLtest.DOM4J;

import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: YHQ
 * @Date: 20-1-29 下午1:26
 */
public class test {
    @Test
    public void test1(){
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(new File("book.xml"));
            Element rootElement = document.getRootElement();
            Iterator iterator = rootElement.elementIterator();
            while (iterator.hasNext()){
                Element book = (Element) iterator.next();
                List<Attribute> attributes = book.attributes();
                for (Attribute a:attributes){
                    System.out.println(a.getName()+":"+a.getValue());
                }
                Iterator child = book.elementIterator();
                while(child.hasNext()){
                    Element c =(Element) child.next();
                    System.out.println(c.getName()+":"+c.getStringValue());
                }
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
    /**
     * 生成xml
     */
    @Test
    public void test2(){
        Document document = DocumentHelper.createDocument();
        Element bookstore = document.addElement("bookstore");
        Element book = bookstore.addElement("book");
        book.addAttribute("id","1");
        book.addElement("name").addText("他改变了中国");
        book.addElement("author").addText("罗伯特");
        book.addElement("price").addText("50");
        Element book2 = bookstore.addElement("book");
        book2.addAttribute("id","2");
        book2.addAttribute("fake","true");
        book2.addElement("name").addText("梁家河");
        book2.addElement("author").addText("xiong");
        book2.addElement("price").addText("5");

        File f = new File("DOM4J_book.xml");
        OutputFormat format = OutputFormat.createPrettyPrint();
        try {
            XMLWriter writer = new XMLWriter(new FileOutputStream(f),format);
            writer.write(document);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
