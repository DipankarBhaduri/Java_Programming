package com.Java_Programming.learning.alpha._15_basicShortingAlgorithams;

import java.util.Arrays;

public class SelectionShorting {
    public static void main(String[] args) {
        int[] arr = { 7,5,3,6,4,2,1} ;
        perfromSelectionShorting(arr);
        System.out.print("SelectionShorting : ");
        System.out.println(Arrays.toString(arr));
    }
    public static void perfromSelectionShorting ( int[] arr ){
        for ( int i = 0 ; i < arr.length - 1 ; i++ ){
            int curr = i ;
            for ( int j = i + 1 ; j < arr.length ; j++ ){
                if ( arr[j] < arr[curr] ){
                    curr = j ;
                }
            }
            int temp = arr[curr] ;
            arr[curr] = arr[i] ;
            arr[i] = temp ;
        }
    }
}
