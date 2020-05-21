package Algorithm.Leetcode;
//Given a string, find the length of the longest substring without repeating characters.

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestSubWithoutRepeat {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0) return 0;
        int max=0;
        Map<Character,Integer> m=new HashMap<>();
        for(int left=0,now=0;now<s.length();now++){
            if(m.containsKey(s.charAt(now))){
                left=Math.max(m.get(s.charAt(now)),left);  //记录当前窗口移动位置
                System.out.println(left);
            }
            max=Math.max(max,now-left+1);
            m.put(s.charAt(now),now+1);
        }
        return max;
    }
    public int length(String s){
        int len = s.length();
        int max=0;
        int ch[]=new int [128];
        for(int i=0,j=0;i<len;i++){
            if(ch[s.charAt(i)]>0){
                j=Math.max(ch[s.charAt(i)],j);
            }
            max=Math.max(max,i-j+1);
            ch[s.charAt(i)]=i+1;
        }
        //中位数
        int a1[],a2[],a3[];
        a1=new int []{1,2,3,4};
        a2=new int []{1,2};
        int z=a1.length+a2.length;
        a3=new int [z];
        for (int i = 0; i < a3.length; i++) {
            if (i<a1.length){
                a3[i]=a1[i];
            }else{
                a3[i]=a2[i-a1.length];
            }
        }
        for (int a:a3
             ) {
            System.out.print(a);
        }
        Arrays.sort(a3);
        if ((z%2)!=0){
            System.out.println(a3[z/2]);
        }else{
            System.out.println((a3[z/2]+a3[z/2-1])/2);
        }
        //结束
        return max;
    }
    public static void main(String args[]){
        LongestSubWithoutRepeat l=new LongestSubWithoutRepeat();
        int a=l.length("abcabcd");
        System.out.println(a);
    }
}
