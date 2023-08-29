package com.Java_Programming.alpha._23_backTracking;

import java.util.ArrayList;
import java.util.List;

public class FindAllSubsetsInArray {
    public static void main(String[] args) {
        int [] arr = {2,4,6,8};
        findAllSubsetsUsingBackTracking(arr, 0, new ArrayList<Integer>());
    }
    private static void findAllSubsetsUsingBackTracking(int[] arr, int i, List<Integer> list) {
        if (i == arr.length) {
            if(list != null && list.size() > 0) {
                System.out.println(list);
            }
            return;
        }

        list.add(arr[i]);
        findAllSubsetsUsingBackTracking(arr,i+1, list);
        findAllSubsetsUsingBackTracking(arr,i+1, list);
    }
}
