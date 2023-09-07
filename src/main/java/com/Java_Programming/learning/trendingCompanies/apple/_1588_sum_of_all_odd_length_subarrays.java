package com.Java_Programming.learning.trendingCompanies.apple;

import java.util.ArrayList;
import java.util.List;

public class _1588_sum_of_all_odd_length_subarrays {
    public static void main(String[] args) {
        int arr[] = {1,4,2,5,3};
        List<Integer> list = new ArrayList<>();
        int [] sum = new int [1];
        allOddLengthSum(arr,0,list,sum);
        System.out.println(sum[0]);
    }
    public static void allOddLengthSum (int[] arr, int index, List<Integer>list, int[] sum) {
        if (index == arr.length) {
            return;
        }

        sum[0] += checkOdd(list);
        List<Integer> newList = new ArrayList<>(list);
        newList.add(arr[index]);
        allOddLengthSum(arr, index+1, newList, sum);
        allOddLengthSum(arr, index+1, list, sum);
    }
    public static int checkOdd (List<Integer> list) {
        if(list != null && list.size() % 2 != 0) {
            int sum = 0;
            for (int x : list){
                sum += x;
            }
            return sum;
        }
        return 0;
    }
}
