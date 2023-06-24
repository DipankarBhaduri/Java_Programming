package com.Java_Programming.leetCode;

import java.util.HashMap;

public class Two_Sum {
    public static void main(String[] args) {
        int[] nums = { 2,7,11,15 } ;
        int target = 17 ;
        int[] ans = Solution.twoSum(nums , target) ;
        System.out.println(nums[ans[0]] +" + "+ nums[ans[1]] +" = " + target );
    }
    class Solution {
        public static int[] twoSum(int[] nums, int target) {
            HashMap<Integer , Integer > integerHashMap = new HashMap<>() ;
            int [] ans = new int [2] ;
            for ( int i = 0 ; i < nums.length ; i++ ){
                if( integerHashMap.containsKey(target - nums[i])){
                    ans [0] = integerHashMap.get(target-nums[i]) ;
                    ans[1] = i ;
                    return ans ;
                } else {
                    integerHashMap.put(nums[i] , i ) ;
                }
            }
            return ans ;
        }
    }
}
