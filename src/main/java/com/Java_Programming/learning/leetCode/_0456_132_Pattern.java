package com.Java_Programming.learning.leetCode;

public class _0456_132_Pattern {
    public static void main(String[] args) {
        int [] nums = {1,0,1,-4,-3};    // ->> [3,5,0,3,4]
        boolean ans = find132pattern(nums);
        System.out.println(ans);
    }

    public static boolean find132pattern(int[] nums) {
        if(nums.length < 3) {
            return false;
        }
        for(int i = 1; i <  nums.length - 1; i++) {
            if(nums[i-1] < nums[i+1] && nums[i+1] < nums[i]) {
                return true;
            }
        }
        return false;
    }
}