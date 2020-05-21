package Algorithm.Leetcode;
//Given an array of integers, return indices of the two numbers such that
//they add up to a specific target.
//You may assume that each input would have exactly one solution,
// and you may not use the same element twice.


import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        char a = needle.charAt(0);
        int max = haystack.length() - needle.length();
        for (int i = 0; i <= max; i++) {
            if (haystack.charAt(i) != a)
                while (++i < max && haystack.charAt(i) != a) ;
            if (i <= max) {
                if (needle.length()==1&&haystack.charAt(i)==needle.charAt(0))
                    return i;
                int j = i + 1;
                int end = j + needle.length() - 1;
                for (int k = 1; j<end && haystack.charAt(j) == needle.charAt(k); k++, j++) {
                    if (j == end-1)
                        return i;
                }
            }
        }
        return -1;
    }
    public static void main(String args[]){
        TwoSum t=new TwoSum();
        int a[]=t.twoSum(new int[]{6,5,3,5},10);
        for (int a1:a
             ) {System.out.println(a1);

        }
        String str1="abcabcdfg";
        String str2="cdg";
        int len=t.strStr(str1,str2);
        System.out.println(len);
    }
}
