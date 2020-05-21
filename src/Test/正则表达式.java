package Test;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: YHQ
 * @Date: 2019/11/17 11:35
 */
public class 正则表达式 {
    public static void main(String args[]) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->System.out.println(test.getInstance().s)).start();
        }
    }
    @Test
    public void test(){
        String regx="[^a-zA-Z0-9][a-zA-Z0-9]bc";
        String str = "!wbc";
        System.out.println(str.matches(regx));
    }
    @Test
    public void test2(){
        String regx = "bcbc";
        String str = "2bcbc2";
        System.out.println(str.matches(regx));
    }
    @Test
    public void test3(){
        String regx = "1654165.51515dddd568";
        byte []b = "̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗̗".getBytes();
        System.out.println(new String(b));
    }
    /**
     * 正则表达式1
     * 匹配邮箱规则：
     * 1. 必须有@符号
     * 2. @符号前至少有一个任意非@非空格字符
     * 3. @符号后至少有一个任意非@非空格字符
     */
    @Test
    public void test4(){
        String regx = "[^@\\s]+@[^@\\s]+";
        String str = "3@qq.com.cn";
        System.out.println(str.matches(regx));
    }

    /**
     * 正则表达式1
     * 匹配邮箱规则：
     * 1. 国际区号开头 四位数字，第一位必须零
     * 2. 省区号是三位数字，0开头和国际区号用空格或-分开，
     * 3. 最后是7到8位任意数字 和省区号用空格或-分开
     */
    /*11115*/
    @Test
    public void test5(){
        String regx = "0\\d{3}( |-)0\\d{2}( |-)\\d{7,8}";
        String str = "0012 001-5645645";
        System.out.println(str.matches(regx));
    }
    //ddddd
    /**
     * 非贪婪匹配
     * 在 * + ？{}等匹配重复次数的符号后加一个？代表非贪婪匹配，也叫最小规则匹配
     */
    @Test
    public void test6(){
        String regx = "\\$\\{(.*?)\\}";
        String str = "0012${aaa}1561${bbb}5555";
        System.out.println(str.replaceAll(regx,"<img src='$1.jpg'/>"));

    }
    @Test
    public void test7(){
        //language=RegExp
        String regx = "\\[(?<wd>.*?)\\]|\\{(.*?)\\}";
        String str = "[hello] {World}!Hi {every} [body]";
        System.out.println(str.replaceAll(regx,"$1$2"));
        Matcher matcher = Pattern.compile(regx).matcher(str);
        while(matcher.find()){
            System.out.println(matcher.group(2));
        }
    }
    @Test
    public void test8(){
        String regx = "/\\*(.*?|.*\\s)+\\*/\\n?|//.*\\s|@.*\\s";
        String str;
        str = "/**\n" +
                "     * 示例1\n" +
                "     * valueOf()\n" +
                "*/" +
                "    @Test\n" +
                "    public void test12(){\n" +
                "        int a = 20;\n" +
                "        double b = 3424.2342;\n" +
                "        char c = 'T';\n" +
                "        boolean d = true;\n" +
                "        Date e = new Date();\n" +
                "        //把数据转换成字符串\n" +
                "        String ss = String.valueOf(a);\n" +
                "        System.out.println(ss);\n" +
                "        ss = String.valueOf(a);\n" +
                "        System.out.println(ss);\n" +
                "        ss = String.valueOf(b);\n" +
                "        System.out.println(ss);\n" +
                "        ss = String.valueOf(c);\n" +
                "        System.out.println(ss);\n" +
                "        ss = String.valueOf(d);\n" +
                "        System.out.println(ss);\n" +
                "/**/\n//4164464\n"+
                "        ss = String.valueOf(e);\n" +
                "        System.out.println(ss);\n" +
                "    }"+"/*\n*/";
        Matcher matcher = Pattern.compile(regx).matcher(str);
        while(matcher.find()){
            System.out.println(matcher.group(0));
        }
//    System.out.println(str.replaceAll(regx,""));
    }
    @Test
    public void test60(){
        String name = "<script>alert('')</script>";
        name = name.replaceAll("[<|>]","");
        System.out.println(name);
    }

}
