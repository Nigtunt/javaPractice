package Algorithm.Leetcode;

import java.util.Stack;
import java.util.Vector;

//有效括号
public class ValidParentheses {
    public boolean isValid(String s) {
        if(s.length()==0) return false;
        Stack<Character> stack=new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='('||s.charAt(i)=='{'||s.charAt(i)=='[')
                stack.push(s.charAt(i));
            else{
                if(stack.empty()) return false;
                switch (s.charAt(i)){
                    case ')': if(stack.pop()!='(') return false; break;
                    case ']': if(stack.pop()!='[') return false; break;
                    case '}': if(stack.pop()!='{') return false; break;
                }
            }
        }
        if (stack.empty()) return true;
        return false;
    }
    public static void main(String args[]){
        ValidParentheses v=new ValidParentheses();
        System.out.println(v.isValid("[[]]()"));
    }
}
