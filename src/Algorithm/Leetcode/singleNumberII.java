package Algorithm.Leetcode;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。
 * 找出那个只出现了一次的元素。
 */

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author: YHQ
 * @Date: 2019/11/28 12:14
 */
public class singleNumberII {
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i]))
                map.put(nums[i],1);
            else{
                if(map.get(nums[i])==1)
                    map.put(nums[i],2);
                else  map.remove(nums[i]);
            }

        }
        Iterator<Integer> it = map.keySet().iterator();
        return it.next();
    }
    public int singleNumber2(int[] nums) {
        int ones = 0, twos = 0;
        for(int num : nums){
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }
    public static void main(String args[]){
           singleNumberII s = new singleNumberII();
           System.out.println(s.singleNumber(new int[]{1,1,1,2,5,4,4,5,4,5}));
    }
}
