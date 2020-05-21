package Algorithm.Leetcode;

import java.util.*;

/**
 * @Author: YHQ
 * @Date: 2019/11/25 20:57
 */
public class LetterPhoneNumber {
    List<String> list = new ArrayList<>();
    Map<Character,String> map = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return list;
        char [] res = new char[digits.length()];
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        look(res,0,digits,map.get(digits.charAt(0)));
        return list;
    }
    public void look(char[] sb,int a,String digits,String value){
        if(a==digits.length()) {
            list.add(new String(sb));
            return;
        }
        char cc = digits.charAt(a);
        String str = map.get(cc);
        value = str;
        while(!value.equals("")){
            sb[a] = value.charAt(0);
            look(sb,a+1,digits,value);
            value = value.substring(1);
        }
    }
    public static void main(String args[]){
        LetterPhoneNumber l = new LetterPhoneNumber();
        long start = System.currentTimeMillis();
        List list = l.letterCombinations("23456789547");
        long end = System.currentTimeMillis();
        System.out.println(end- start);
    }
}
