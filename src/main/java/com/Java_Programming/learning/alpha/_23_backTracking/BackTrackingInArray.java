package com.Java_Programming.learning.alpha._23_backTracking;

import java.util.Arrays;

public class BackTrackingInArray {

    public static void main(String[] args) {
        int [] arr = new int [5] ;
        backTrackingOnArray(arr , 0 , 5 );
        printArray(arr);
    }

    public static void printArray (int [] arr ){
        System.out.println(Arrays.toString(arr));
    }

    public static void backTrackingOnArray ( int [] arr , int index , int val ){
        if ( index == arr.length ){
            printArray(arr);
            return ;
        }

        arr[index] = val ;
        backTrackingOnArray(arr,index+1 , val+1);
        arr[index] -= 2 ;
    }
}
