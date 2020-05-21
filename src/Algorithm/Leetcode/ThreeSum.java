package Algorithm.Leetcode;
//Given an array nums of n integers, are there elements a, b, c in nums
// such that a + b + c = 0? Find all unique triplets in the array
// which gives the sum of zero.
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> L=new ArrayList();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0) return L;
            if(i>0&&nums[i]==nums[i-1]) continue;
            int k=i+1,j=nums.length-1;
            while(k<j){
                int sum=nums[i]+nums[k]+nums[j];
                if(sum>0){
                    while(k<j&&nums[j]==nums[--j]);
                }else if(sum<0){
                    while(k<j&&nums[k]==nums[++k]);
                }else{
                    L.add(new ArrayList<Integer>(Arrays.asList(nums[i],nums[k],nums[j])));
                    while(k<j&&nums[k]==nums[++k]);
                    while(k<j&&nums[j]==nums[--j]);
                }
            }
        }
        return L;
    }
    public static void main(String args[]){
        ThreeSum t=new ThreeSum();
        List<List<Integer>> L=t.threeSum(new int[]{-1,0,1,2,-1,-4});
        for (int i = 0; i < L.size(); i++) {
            for (int i1 = 0; i1 < L.get(i).size(); i1++) {
                System.out.print(L.get(i).get(i1));
            }
            System.out.println();
        }
    }
}
