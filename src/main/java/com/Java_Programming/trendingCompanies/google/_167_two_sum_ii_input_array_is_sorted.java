package com.Java_Programming.trendingCompanies.google;

import java.util.Arrays;

public class _167_two_sum_ii_input_array_is_sorted {
    /**
     * @Link : https://leetcode.com/problems/two-sum/
     */
    public static void main(String[] args) {
        int [] nums = { 2,3,6,7,11,13};
        int target = 9;
        int [] response = twoSum(nums, target);
        System.out.println(Arrays.toString(response));
    }

    /**
     * @param numbers : This nums array is already shorted in accending order
     * @param target : Target element need to find using two element from the nums array
     * @return : This will return integer Array where will be stored the two index of Element for target element
     */
    public static int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;
        while ( start < end ){
            if (numbers[start]+numbers[end] == target) {
                return new int[] {start, end};
            } else if (numbers[start]+numbers[end] < target){
                start++;
            } else {
                end--;
            }
        }
        return new int[] {-1,-1};
    }
}
