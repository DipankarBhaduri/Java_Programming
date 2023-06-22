package com.Java_Programming.basicShortingAlgo;

public class InsertionShorting {
    public static void main(String[] args) {
        int [] arr = { 6,3,7,2,4,1,5 ,12,8,11,21 ,16} ;
        insertion(arr);
        for(int val : arr ){
            System.out.print(val+" -> ");
        }
    }
    public static void insertion (int[] arr ){
        for(int i = 1 ; i < arr.length ; i++ ){
           int curr = arr[i] ;
           int prev = i - 1 ;
           while (prev >= 0 && curr < arr[prev]){
               arr[prev+1] = arr[prev] ;
               prev-- ;
           }
           arr[prev+1] = curr ;
        }
    }
}
