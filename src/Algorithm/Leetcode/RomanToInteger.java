package Algorithm.Leetcode;
//RomanToInteger and longestCommonPrefix
public class RomanToInteger {
    public int romanToInt(String s) {
        if(s.length()==0)return 0;
        int a[]=new int [s.length()];
        for(int i=0;i<s.length();i++){
            switch(s.charAt(i)){
                case 'I': a[i]=1; break;
                case 'V': a[i]=5;break;
                case 'X': a[i]=10;break;
                case 'L': a[i]=50;break;
                case 'C': a[i]=100;break;
                case 'D': a[i]=500;break;
                case 'M': a[i]=1000;break;
            }
        }
        int sum=0;
        for (int i = 0; i < a.length; i++) {
            if(i+1<a.length){
                if (a[i]>=a[i+1])
                    sum+=a[i];
                else
                    sum-=a[i];
            }
        }
        sum+=a[a.length-1];
        return sum;
    }
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==1) return strs[0];
        if(strs.length==0||strs[0].length()==0) return "";
        String s=strs[0];
        for(int i=1;i<strs.length;i++){
            int j=0;
            for(;j<strs[i].length()&&j<s.length();j++){
                if(strs[i].charAt(j)!=s.charAt(j)){
                    break;
                }
            }
            s=strs[i].substring(0,j);
        }
        if(s.length()==0) return "";
        return s;
    }
    public static void main(String args[]){
        RomanToInteger r=new RomanToInteger();
        System.out.println(r.romanToInt("III"));
        String temp=r.longestCommonPrefix(new String[]{"a","a","bc"});
        System.out.println(temp);
    }
}
