package XMLtest.JDOM;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author: YHQ
 * @Date: 2020/1/28 13:03
 */
public class test {
    @Test
    public void test1(){
        SAXBuilder builder = new SAXBuilder();
        //创建输入流
        InputStream in;
        try {
            in = new FileInputStream("book.xml");
            Document build = builder.build(in);
            Element rootElement = build.getRootElement();
            List<Element> children = rootElement.getChildren();
            for (Element book:children){
                System.out.println("第"+(children.indexOf(book)+1)+":"+book.getName());
                List<Attribute> attributes = book.getAttributes();
                for(Attribute att:attributes){
                    System.out.println(att.getName()+":"+att.getValue());
                }
                List<Element> bookChildren = book.getChildren();
                for (Element bc:bookChildren){
                    System.out.println(bc.getName()+":"+bc.getValue());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    /**
     * 生成xml
     */
    @Test
    public void test2(){
        Element bookstore = new Element("bookstore");
        Element book = new Element("book");
        book.setAttribute("id","1");
        Element name = new Element("name");
        name.setText("他改变了中国");
        Element author = new Element("author");
        author.setText("<dwadaw>");
        Element price = new Element("price");
        price.setText("50");
        book.addContent(name).addContent(author).addContent(price);
        bookstore.addContent(book);
        Document document = new Document(bookstore);
        XMLOutputter xml = new XMLOutputter();
        Format f = Format.getPrettyFormat();
        xml.setFormat(f);
        try {
            xml.output(document,new FileOutputStream("JDOM_book.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
