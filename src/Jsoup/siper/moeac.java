package Jsoup.siper;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: YHQ
 * @Date: 2020/3/2 20:13
 */
public class moeac {
    @Test
    public void test() throws IOException {
        for (int i = 1; i < 2; i++) {
            String url = "https://moe.ac/page/"+i+"?s&post_type=post";
            pageopen(url,i);
        }
    }

    private void pageopen(String url,int count) throws IOException {
        BufferedWriter buffer = new BufferedWriter(
                new FileWriter("D:\\BaiduYunDownload\\moeac\\image\\" + count + ".html"));
        buffer.write("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n");
        Connection connect = Jsoup.connect(url);
        Map<String,String> map = new HashMap<>();
        map.put("user-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.120 Safari/537.36");
        map.put("accept-language","zh-CN,zh;q=0.9,en-US;q=0.8,en;q=0.7");
        map.put("accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3");
        String raw = "wordpress_logged_in_99b2a84bc4eda9015536c410eaec2c48=15736987389%7C1583646394%7ChU2rx9DrmI9HM5R6JevW1QhDB2HA3bHh9WraGGZBFPV%7Cd5d27064a5d039a8b5e45fa2c199e538fb8155b92b2f2cb289394fa2ce31eae2; Hm_lvt_93616c83ae96954f0a59a7867529469c=1582259721,1582436703,1582876385,1583147028; Hm_lvt_49cc02c62fdb09c867c9340508d5af34=1582259721,1582436703,1582876385,1583147028; Hm_lpvt_93616c83ae96954f0a59a7867529469c=1583151154; Hm_lpvt_49cc02c62fdb09c867c9340508d5af34=1583151154";
        String[] cookies = raw.split("; ");
        Map<String,String> cookie = new HashMap<>();
        for (int i = 0; i < cookies.length; i++) {
            cookie.put(cookies[i].split("=")[0],cookies[i].split("=")[1]);
        }
        connect.headers(map).cookies(cookie);

        Document document = connect.get();
        Elements elementsByClass = document.getElementsByClass("pos-r cart-list");
        for (Element e:elementsByClass){
            Elements h2 = e.getElementsByTag("h2");
            buffer.write(h2+"<br>");

            Elements select = e.select("[style~=background-image]");
            String style = select.attr("style");
            Matcher matcher = Pattern.compile(".*url\\('(.*)'\\)").matcher(style);
            if (matcher.find())
                buffer.write("<img src=\""+matcher.group(1)+"\" />");
            Element element = h2.get(0);
        }

        buffer.write(" </body></html>");
        buffer.close();
    }
}
