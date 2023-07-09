package com.Java_Programming.alpha._20_recursionBasic;

import java.util.Arrays;

public class SelectionShortUsingRecursion {
    public static void main(String[] args) {
        int[] arr = {6,3,7,2,5,4,1} ;
        perfromSelectionShortUsingRecursion(arr , 0);
        System.out.println(Arrays.toString(arr));
    }
    public static void perfromSelectionShortUsingRecursion ( int [] arr , int start ){
        if ( start == arr.length - 1 ){
            return;
        }

        int small = start ;
        for ( int i = start ; i < arr.length ; i++ ){
            if ( arr[i] < arr[small]){
                small = i ;
            }
        }
        int temp = arr[start] ;
        arr[start] = arr[small] ;
        arr[small] = temp ;

        perfromSelectionShortUsingRecursion(arr , start+1);
    }
}
