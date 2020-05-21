package Jsoup;

import com.mysql.cj.util.Base64Decoder;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.seimicrawler.xpath.JXDocument;
import org.seimicrawler.xpath.JXNode;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * @Author: YHQ
 * @Date: 2020/2/20 13:24
 */
public class test {
    @Test
    public void test1() throws IOException, InterruptedException {
        Connection connect = Jsoup.connect("https://blog.csdn.net/weixin_44462294");
        Map<String,String> map = new HashMap<>();
        map.put("user-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.120 Safari/537.36");
        map.put("accept-language","zh-CN,zh;q=0.9,en-US;q=0.8,en;q=0.7");
        map.put("accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3");
        connect.headers(map);
        connect.method(Connection.Method.GET);
        Document document = connect.get();
        Elements article = document.getElementsByClass("article-list");
        Elements a = article.select("[href]");
        ArrayList<String> list = new ArrayList<>();
        int count = 0;
        for (Element node:a){
            if (count%2==0&&count>20){
                list.add(node.attr("href"));
            }
            count++;
        }
        while (true){
            for (String aList : list) {
                long start = System.currentTimeMillis();
                Connection c = Jsoup.connect(aList);
                c.headers(map);
                c.method(Connection.Method.GET);
                Connection.Response execute = c.execute();
                System.out.println(execute.statusCode());
                Document document1 = c.get();
                Elements title = document1.getElementsByTag("title");
                for (Element t : title) {
                    System.out.println(t.text());
                }
                System.out.println("用时："+(System.currentTimeMillis()-start));
                Thread.sleep(Math.round(2000 + Math.random() * 1000));
            }
        }

    }
    @Test
    public void test3() throws NoSuchAlgorithmException {
        Base64.Encoder encoder = Base64.getEncoder();
        Base64.Decoder decoder = Base64.getDecoder();
        String s = encoder.encodeToString("苟利国家生死以".getBytes());
        for (int i = 0; i < decoder.decode(s).length; i++) {
            System.out.println(decoder.decode(s)[i]);
        }
        MessageDigest md = MessageDigest.getInstance("md5");
    }
    public static void main(String args[]){
        for (int i = 0; i < 100; i++) {
            new Thread(()-> {
                try {
                    System.out.println(Jsoup.connect("http://192.168.0.106/hello").execute().body());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }
}
