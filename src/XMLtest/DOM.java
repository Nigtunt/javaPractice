package XMLtest;

import org.junit.Test;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

/**
 * @Author: YHQ
 * @Date: 2020/1/9 17:26
 */
public class DOM {
    /**
     * DOM
     */
    @Test
    public void test1(){
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse("book.xml");
            NodeList nodeList = document.getElementsByTagName("book");
            for (int i = 0,len=nodeList.getLength(); i < len; i++) {
                Node n  =nodeList.item(i);
                NamedNodeMap nnm = n.getAttributes();
                for (int i1 = 0; i1 < nnm.getLength(); i1++) {
                    Node attr = nnm.item(i1);
                    System.out.println(attr.getNodeName()+"="+attr.getNodeValue());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test2(){
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse("book.xml");
            NodeList nodeList = document.getElementsByTagName("book");
            for (int i = 0,len=nodeList.getLength(); i < len; i++) {
                Node n = nodeList.item(i);
                NodeList child = n.getChildNodes();
                for (int j = 0; j < child.getLength(); j++) {
                    if (child.item(j).getNodeType() == Node.ELEMENT_NODE){
                        System.out.println(child.item(j).getNodeName()+":"+child.item(j).getTextContent());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * dom存储xml
     */
    @Test
    public void test3(){
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.newDocument();
            document.setXmlStandalone(true);   //不显示standalone
            Element bookstore = document.createElement("bookstore");
            document.appendChild(bookstore);
            Element book = document.createElement("book");

            book.setAttribute("id","1");
            book.setTextContent("dwada");
            bookstore.appendChild(book);

            TransformerFactory tff = TransformerFactory.newInstance();
            Transformer transformer = tff.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT,"yes");  //是否换行
            transformer.transform(new DOMSource(document),new StreamResult(new File("DOM_book.xml")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
