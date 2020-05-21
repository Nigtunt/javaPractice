package Algorithm;

import java.util.Stack;

/**
 * @Author: YHQ
 * @Date: 2019/11/2 11:39
 */
public class twoStackAQueue {
    public int NumberOf1(int n) {
        int count = 0;
        while(n!= 0){
            count++;
            n = n & (n - 1);
        }
        return count;
    }
    public static void main(String args[]){
        twoStackAQueue t = new twoStackAQueue();
        System.out.println(t.NumberOf1(1156115));
    }
}
