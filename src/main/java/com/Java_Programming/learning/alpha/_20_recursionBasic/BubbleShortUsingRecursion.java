package com.Java_Programming.learning.alpha._20_recursionBasic;

import java.util.Arrays;

public class BubbleShortUsingRecursion {
    public static void main(String[] args) {
        int[] arr = {6,3,7,2,5,4,1} ;
        int n = arr.length - 1 ;
        perfromBubbleShortUsingRecursion(arr , n);
        System.out.println(Arrays.toString(arr));
    }
    public static void perfromBubbleShortUsingRecursion ( int[] arr , int n){
        if ( n == 0 ){
            return;
        }
        for ( int i = 0 ; i < n ; i++ ){
            if ( arr[i] > arr[i+1] ){
                int temp = arr[i] ;
                arr[i] = arr[i+1] ;
                arr[i+1] = temp ;
            }
        }
        perfromBubbleShortUsingRecursion(arr , n- 1 );
    }
}
