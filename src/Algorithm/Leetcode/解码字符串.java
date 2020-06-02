package Algorithm.Leetcode;

import java.util.LinkedList;

/**
 * @Author: YHQ
 * @Date: 2020/5/29 14:31
 */
public class 解码字符串 {
    public static String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int count = 0;
        LinkedList<Integer> stack_count = new LinkedList<>();
        LinkedList<String> stack_res = new LinkedList<>();
        int len = s.length();

        for (int i = 0; i < len; i++) {
            char cur = s.charAt(i);
            if (Character.isDigit(cur)){
                count = Integer.parseInt(cur+"");
            }else if (cur=='['){
                stack_count.addLast(count);
                stack_res.addLast(res.toString());
                count = 0;
                res = new StringBuilder();
            }else if (cur==']'){
                StringBuilder temp = new StringBuilder();
                Integer last = stack_count.removeLast();
                for (Integer integer = 0; integer < last; integer++) {
                    temp.append(res);
                }
                res = new StringBuilder(stack_res.removeLast() + temp);
            }else {
                res.append(cur);
            }
        }
        return res.toString();
    }
    public static void main(String args[]){
        System.out.println(decodeString("3[c3[d]]ef"));
    }

}
