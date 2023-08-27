package com.Java_Programming.trendingCompanies.microsoft;
import java.util.*;

public class _229_majority_element_ii {
    public static void main(String[] args) {
        int[] nums = {3,2,3};
        List<Integer> ans = majorityElement(nums);
        System.out.println(ans);
    }
    public static List<Integer> majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int appearRequired = (nums.length/3);
        if ( nums.length < 3){
            for ( int num : nums ){
                list.add(num);
            }
            return list;
        }

        for ( int num : nums ){
            if (!map.containsKey(num)){
                map.put(num,1);
            } else {
                map.put(num,map.get(num)+1);
            }
        }

        for ( Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() > appearRequired){
                list.add(entry.getKey());
            }
        }
        return list ;
    }
}