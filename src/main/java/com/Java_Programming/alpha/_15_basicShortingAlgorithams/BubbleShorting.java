package com.Java_Programming.alpha._15_basicShortingAlgorithams;

import java.util.Arrays;

public class BubbleShorting {
    public static void main(String[] args) {
        int [] arr = { 6,3,8,4,2,7,1,5};
        perfromBubbleShorting(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void perfromBubbleShorting ( int[] arr ){
        for ( int i = 1 ; i < arr.length ; i++ ){
            for ( int j = 0 ; j < arr.length - i ; j++ ){
                if ( arr[j] > arr[j+1]){
                    int temp = arr[j] ;
                    arr[j] = arr[j+1] ;
                    arr[j+1] = temp ;
                }
            }
        }
    }
}
