package com.Java_Programming.trendingCompanies.google;

public class _1909_remove_one_element_to_make_the_array_strictly_increasing {
    /**
     * @Link : https://leetcode.com/problems/remove-one-element-to-make-the-array-strictly-increasing/
     * @param args
     */
    public static void main(String[] args){
        /**
         * @Example-1 :
         * Input: nums = [1,2,10,5,7]
         * Output: true
         */
        int[] nums = {1,2,10,5,7};
        Boolean response = removeOneElementToMakeTheArrayStrictlyIncreasing(nums);
        System.out.println(response);
    }
    public static boolean removeOneElementToMakeTheArrayStrictlyIncreasing (int[] nums) {
        if (nums.length < 3) {
            return true;
        }
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {

        }

        return false;
    }
}
