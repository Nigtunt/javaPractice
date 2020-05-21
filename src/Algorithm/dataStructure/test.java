package Algorithm.dataStructure;
import java.util.Stack;
/**
 * @Author: YHQ
 * @Date: 2019/11/3 16:40
 */
class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if(minStack.empty()){
            minStack.push(x);
        }else{
            if(minStack.peek() >= x){
                minStack.push(x);
            }
        }
    }

    public void pop() {
        int temp = stack.pop();
        if(!minStack.empty()&&temp == minStack.peek())
            minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return  minStack.peek();
    }
}
public class test {
    public static void main(String args[]){
        String s = "1";
        String s2= s.substring(1);

    }
}
