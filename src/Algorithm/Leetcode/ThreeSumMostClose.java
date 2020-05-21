package Algorithm.Leetcode;

import java.util.Arrays;
/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
 * 找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。
 * 假定每组输入只存在唯一答案。
 */

/**
 * @Author: YHQ
 * @Date: 2019/11/25 19:58
 */
public class ThreeSumMostClose {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0]+nums[1]+nums[2];
        for(int i=0;i<nums.length;i++){
            if(i>0&&nums[i]==nums[i-1]) continue;
            int k=i+1,j=nums.length-1;
            while(k<j){
                int sum=nums[i]+nums[k]+nums[j];
                if (Math.abs(sum-target)<Math.abs(res-target)){
                    res = sum;
                }
                if (sum<target){
                    while(k<j&&nums[k]==nums[++k]);
                }else if(sum>target){
                    while (k<j&&nums[j]==nums[--j]);
                }else{
                    return sum;
                }
            }
        }
        return res;
    }
    public static void main(String args[]){
        ThreeSumMostClose t = new ThreeSumMostClose();
        System.out.println(t.threeSumClosest(new int[]{6,-18,-20,-7,-15,9,18,10,1,-20,-17,-19,-3,-5,-19,10,6,-11,1,-17,-15,6,17,-18,-3,16,19,-20,-3,-17,-15,-3,12,1,-9,4,1,12,-2,14,4,-4,19,-20,6,0,-19,18,14,1,-15,-5,14,12,-4,0,-10,6,6,-6,20,-8,-6,5,0,3,10,7,-2,17,20,12,19,-13,-1,10,-1,14,0,7,-3,10,14,14,11,0,-4,-15,-8,3,2,-5,9,10,16,-4,-3,-9,-8,-14,10,6,2,-12,-7,-16,-6,10},
        -52));

    }
}
