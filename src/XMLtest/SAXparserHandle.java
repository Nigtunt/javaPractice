package XMLtest;

import XMLtest.SAX_store.book;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

/**
 * @Author: YHQ
 * @Date: 2020/1/27 16:19
 */
public class SAXparserHandle extends DefaultHandler {
    /*String value = null;
    book b = null;
    ArrayList<book> list = new ArrayList<>();*/
    private String value = null;
    @Override
    public void startDocument() throws SAXException {
        System.out.println("SAX解析开始");
        super.startDocument();
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        System.out.println("SAX解析结束");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        /*if (qName.equals("book")){
            b = new book();
            for (int i = 0; i < attributes.getLength(); i++) {
                String value = attributes.getValue(i);
                String name = attributes.getQName(i);
                if (name.equals("id")){
                    b.setId(Integer.parseInt(value));
                }
            }
        }*/
        if (qName.equals("student")){
            for (int i = 0; i < attributes.getLength(); i++) {
                System.out.println(attributes.getQName(i)+"="+attributes.getValue(i));
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        /*if (qName.equals("author")){
            b.setAuthor(value);
        }else if (qName.equals("name")){
            b.setName(value);
        }else if (qName.equals("price")){
            b.setPrice(Float.parseFloat(value));
        }else if (qName.equals("book")){
            list.add(b);
            b = null;
        }*/
        if (qName.equals("name")){
            System.out.println("name"+":"+value);
        }else if (qName.equals("age")){
            System.out.println("age"+":"+value);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        value = new String(ch,start,length);
    }
}
