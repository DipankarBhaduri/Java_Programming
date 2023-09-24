package com.Java_Programming.learning.leetCode;

import java.util.Arrays;

public class _0088_merge_sorted_array {
    public static void main(String[] args) {
        int nums1 [] = {4,5,6,0,0,0}, m = 3, nums2[] = {1,2,3}, n = 3;
        merge(nums1,m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int l1 = 0;
        int l2 = 0;
        while(l1 < nums1.length || l2 < nums2.length) {
            if(l1 < m && l2 < n && nums1[l1] < nums2[l2]){
                l1++;
            }else if (l1 < m && l2 < n) {
                int temp = nums1[l1];
                nums1[l1] = nums2[l2];
                nums2[l2] = temp;
                l1++;
            }else if(l1 < nums1.length && l2 < n){
                nums1[l1++] = nums2[l2++];
            }
        }
    }
}
