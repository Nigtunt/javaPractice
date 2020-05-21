package Algorithm.蓝桥杯;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Author: YHQ
 * @Date: 2019/11/9 12:41
 */
public class 回文数 {
    int n;
    String m;
    public boolean ishuiwen(String m){
        int i=0,k=m.length()-1;
        while(i<k){
            if(m.charAt(i)!=m.charAt(k))
                return false;
            k--;i++;
        }
        return true;
    }
    public long stringtoint(String m){
        long sum=0;
        for (int i = 0; i < m.length(); i++) {
            if(m.charAt(i)>'A')
                sum = sum*n+10+m.charAt(i)-'A';
            else
                sum = sum*n+m.charAt(i)-'0';
        }

        return sum;
    }
    public String inttostring(long m){
        StringBuffer string=new StringBuffer();
        while(m!=0){
            long temp = m%n;
            if (temp>=10){
                string.append((char)(temp+'A'-10));
            }
            else string.append((char)(temp+'0'));
            m /= n;
        }

        return string.reverse().toString();
    }
    public void cc(){
        int count = 0;
        while(!ishuiwen(m)&&count<=30){
            StringBuffer stringBuffer=new StringBuffer(m);
            long sum = stringtoint(m)+stringtoint(stringBuffer.reverse().toString());
            m = inttostring(sum);
            System.out.println(m);
            count++;
        }
        System.out.println(count);
    }
    public static void main(String args[]){
        回文数 t= new 回文数();
        t.n=9;
        t.m="87";
        t.cc();
    }
}
