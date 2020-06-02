package Algorithm.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: YHQ
 * @Date: 2020/5/28 8:38
 */
public class Main {
    public static int countPrimes(int n) {
        boolean num[] = new boolean[n];
        Arrays.fill(num,true);
        for (int i=2;i<n;){
            for (int t=2;t * i<n;t++){
                num[t*i] = false;
            }
            i++;
            if (i==n) break;
            while(i<n&&!num[i]) i++;
        }

        int count = 0;
        for (int i = 2; i < num.length; i++) {
            if (num[i]) count++;
        }
        return count;
    }
    public static void main(String args[]){
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        list.add(1,50);
        System.out.println(list);
    }

}
