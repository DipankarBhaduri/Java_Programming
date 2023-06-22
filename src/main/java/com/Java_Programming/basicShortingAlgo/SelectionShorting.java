package com.Java_Programming.basicShortingAlgo;

import java.util.Arrays;

public class SelectionShorting {
    public static void main(String[] args) {
        int [] arr = { 88,45,24,23,11,34,54,32,54,36,85} ;
        selection(arr);
        Arrays.stream(arr)
                .forEach(element -> System.out.print(element+" -> "));
    }
    public static void selection ( int[] arr ){
        for(int i = 0 ; i < arr.length - 1 ; i++ ){
            int minElement = i ;
            for( int j = i+1 ; j < arr.length ; j++ ){
               if( arr[j] < arr[minElement]){
                   minElement = j ;
               }
            }
            int temp = arr[i] ;
            arr[i] = arr[minElement] ;
            arr[minElement] =  temp ;
        }
    }
}
