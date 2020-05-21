package XMLtest;

import XMLtest.SAX_store.book;
import org.junit.Test;
import org.xml.sax.helpers.AttributesImpl;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.*;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;

/**
 * @Author: YHQ
 * @Date: 2020/1/9 18:13
 */
public class SAX {
    @Test
    public void test1(){
        //获取SAXParserFactory
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser();
            SAXparserHandle handle = new SAXparserHandle();
            saxParser.parse("book.xml",handle);
            /*System.out.println(handle.list.size());
            for(book b:handle.list)
                System.out.println(b.getName());*/



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 储存xml
     */
    @Test
    public void test2(){
        SAXTransformerFactory stff = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
        try {
            TransformerHandler tfh = stff.newTransformerHandler();
            Transformer tr = tfh.getTransformer();
            tr.setOutputProperty(OutputKeys.ENCODING,"utf-8");
            tr.setOutputProperty(OutputKeys.INDENT,"yes");
            Result result = new StreamResult(new FileOutputStream("SAX_book.xml"));
            tfh.setResult(result);

            tfh.startDocument();
            AttributesImpl att = new AttributesImpl();
            tfh.startElement("","","bookstore",att);
            att.clear();
            att.addAttribute("","","id","","1");
            tfh.startElement("","","book",att);
            tfh.characters("dwadaw".toCharArray(),0,"dwadaw".length());
            tfh.endElement("","","book");
            tfh.endElement("","","bookstore");
            tfh.endDocument();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
