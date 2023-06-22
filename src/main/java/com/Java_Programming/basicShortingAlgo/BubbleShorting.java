package com.Java_Programming.basicShortingAlgo;

public class BubbleShorting {
    public static void main(String[] args) {
        int [] arr = { 6,3,7,2,4,1,5 ,12,8,11,21 ,16} ;
        bubble(arr);
        for(int val : arr ){
            System.out.print(val+" -> ");
        }
    }
    public static void bubble(int[] arr ){
        for(int i = 0 ; i < arr.length ; i++ ){
            for(int j = 0 ; j < arr.length - i - 1 ; j++ ){
                if( arr[j] > arr[j+1]){
                    int temp = arr[j] ;
                    arr[j] = arr[j+1] ;
                    arr[j+1] = temp ;
                }
            }
        }
    }
}
