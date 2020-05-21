package Algorithm.Leetcode;

import java.util.PriorityQueue;

/**
 * @Author: YHQ
 * @Date: 2020/1/5 18:16
 */
public class 数据流的中位数 {
    private int count;
    private PriorityQueue<Integer> max;
    private PriorityQueue<Integer> min;

    public 数据流的中位数() {
        count = 0;
        max = new PriorityQueue<>((x,y)->(y-x));
        min  = new PriorityQueue<>();
    }
    public void addNum(int num) {
        count++;
        max.offer(num);
        min.offer(max.poll());
        if(max.size()<min.size()){
            max.offer(min.poll());
        }
    }

    public double findMedian() {
        if(count % 2 ==0){
            return (max.peek() + min.peek()) / 2.0;
        }
        return max.peek();
    }
    public static void main(String args[]){
        数据流的中位数 ww = new 数据流的中位数();
    }
}
