package com.Java_Programming.learning.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _2610_convert_an_array_into_a_2d_array_with_conditions {
    public static void main(String[] args) {
        int [] nums = {1,3,4,1,2,3,1};
        List<List<Integer>> ans = findMatrix(nums);
        System.out.println(ans);
    }

    public static List<List<Integer>> findMatrix(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        int size = map.size();
        while(size != 0) {
            List<Integer> temp = new ArrayList<>();
            List<Integer> singleElement = new ArrayList<>();
            for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
                int val = entry.getValue();
                int key = entry.getKey();
                if(val == 1) {
                    temp.add(key);
                    singleElement.add(key);
                } else {
                    temp.add(key);
                    map.put(key, val-1);
                }
            }
            for(int val : singleElement) {
                map.remove(val);
            }
            size = map.size();
            ans.add(temp);
        }
        return ans;
    }
}
