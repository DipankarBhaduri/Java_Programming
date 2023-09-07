package com.Java_Programming.learning.alpha._15_basicShortingAlgorithams;

import java.util.Arrays;

public class InsertionShorting {
    public static void main(String[] args) {
        int [] arr = { 7,5,6,3,4,2,1};
        perfromInsertionShorting(arr);
        System.out.print("Insertion Shorting : "+ Arrays.toString(arr));
    }

    public static void perfromInsertionShorting ( int[] arr ){
        for ( int i = 1 ; i < arr.length ; i++ ){
            int curr = arr[i] ;
            int prev = i - 1 ;
            while ( prev >= 0 && curr < arr[prev]){
                arr[prev+1] =  arr[prev] ;
                prev--;
            }

            arr[prev+1] = curr ;
        }
    }
}
