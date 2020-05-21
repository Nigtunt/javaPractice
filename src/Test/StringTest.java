package Test;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;

/**
 * @Author: YHQ
 * @Date: 2019/11/17 9:21
 */
public class StringTest {
    @Test
    public void test(){
        String str1 = "hello world";
        String str2 = "hello world";
        try {
            byte [] b = "的ha去".getBytes("gbk");
            for (byte bt:b
                 ) {
                System.out.print(bt+" ");
            }
            System.out.println(new String(b));
            byte [] b2 = "的ha去".getBytes();
            for (byte bt:b2
            ) {
                System.out.print(bt+" ");
            }
            System.out.println(new String(b2));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test2(){
        String str1 = "%d年%d月%d日，收入%.2f";
        String str2 = String.format(str1, 2019,11,17,151.55555);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("2019");
        System.out.println(str2.contains(stringBuffer));
    }
    @Test
    public void test3(){
        String str1 = "%d年%d月%d日，收入%.2f";
        String str2 = String.format(str1, 2019,11,17,151.55555);
        String target = "2019";
        String newstr = "2020";
        System.out.println(str2.replace(target,newstr));
        String num = "aa2aa";
        System.out.println(num.replace("aa","b"));
    }

    @Test
    public void test4(){
        String a = "11";
        String b = "1";
        int ans = 0, cur;
        StringBuilder sb = new StringBuilder();
        int i = a.length()-1, j = b.length()-1;
        while(i>=0&&j>=0){
            cur = (a.charAt(i)+b.charAt(j)-'0'*2+ans) % 2;
            ans = (a.charAt(i)+b.charAt(j)-'0'*2+ans) / 2;
            sb.append(cur);
            i--;j--;
        }
        if (i!=-1){
            while (i>=0&&ans!=0){
                cur = (a.charAt(i)-'0'+ans) % 2;
                ans = (a.charAt(i)-'0'+ans) / 2;
                sb.append(cur);
                i--;
            }
            while (i>=0){
                sb.append(a.charAt(i));
                i--;
            }
        }else {
            while (j>=0&&ans!=0){
                cur = (b.charAt(j)-'0'+ans) % 2;
                ans = (b.charAt(j)-'0'+ans) / 2;
                sb.append(cur);
                j--;
            }
            while (j>=0){
                sb.append(b.charAt(j));
                j--;
            }
        }
        if (ans!=0)
            sb.append(ans);
        System.out.println(sb.reverse().toString());
    }
}
