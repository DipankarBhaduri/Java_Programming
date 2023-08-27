package com.Java_Programming.trendingSheet;

import java.util.*;

public class _01_two_sum {
    /**
     * @Link : https://leetcode.com/problems/two-sum/
     */
    public static void main(String[] args) {
         int [] nums = {2, 5, 7, 11, 13};
         int target = 9;
         List<Integer> response = findTarget(nums, target);
         System.out.println(response);
    }
    /**
     * @param : This method will search two element such that addition of them is equal to target element
     * @return : This method will return List of Integer
     */
    public static List<Integer> findTarget(int [] nums, int target){
        List<Integer> list = new ArrayList<>() ;
        Map<Integer,Integer> map = new HashMap<>() ;
        for (int i = 0 ; i < nums.length ; i++){
            if (map.containsKey(target-nums[i])){
                list.addAll(List.of(map.get(target-nums[i]), i )) ;
            } else {
                 map.put(nums[i],i) ;
            }
        }
        return list ;
    }
}
