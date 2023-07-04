package com.Java_Programming.alpha._15_basicShortingAlgorithams;

import java.util.Arrays;

public class CountingShort {
    public static void main(String[] args) {
        int [] arr = { 2,1,3,2,1,4,5,6,4,7} ;
        perfromCountingShort(arr);
        System.out.print("Counting Short : "+ Arrays.toString(arr));
    }
    public static void perfromCountingShort ( int [] arr ){
        int [] count = new int [arr.length] ;
        for ( int i = 0 ; i < arr.length ; i++ ){
            int curr = arr[i] ;
            count[curr] += 1 ;
        }
        int index = 0 ;
        for ( int i = 0 ; i < count.length ; i++ ){
            int curr = count[i] ;
            while ( curr > 0 ){
                arr[index++] = i ;
                curr --;
            }
        }
    }
}
