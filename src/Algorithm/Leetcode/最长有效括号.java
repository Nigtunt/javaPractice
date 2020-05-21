package Algorithm.Leetcode;


import java.util.Stack;

public class 最长有效括号 {
    public int longestValidParentheses(String s) {
        if(s.length()==0) return 0;
        Stack<Integer> stack = new Stack<>();
        int count = 0,max = 0;
        stack.push(-1);
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)=='('){
                stack.push(i);
            }else {
                stack.pop();
                if (stack.empty())
                    stack.push(i);
                else
                    max = Math.max(max,i - stack.peek());
            }

        }
        return max;
    }
        public static void main(String args[]) {
            最长有效括号 main= new 最长有效括号();
            System.out.println(main.longestValidParentheses("()(())"));
    }





}
