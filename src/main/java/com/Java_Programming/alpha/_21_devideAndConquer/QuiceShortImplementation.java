package com.Java_Programming.alpha._21_devideAndConquer;

import java.util.Arrays;

public class QuiceShortImplementation {
    public static void main(String[] args) {
        int [] arr = {5,3,6,2,4,1,8,7} ;
        quickShorting(arr,0,arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickShorting ( int[] arr , int start , int end ){
        if ( start >= end ){
            return;
        }
        int pIndex = partition ( arr , start , end ) ;
        quickShorting(arr ,start, pIndex-1);
        quickShorting(arr ,pIndex+1, end);
    }

    private static int partition(int[] arr, int start, int end) {
        int pivit = arr[end] ;
        int i = start - 1 ;

        for ( int j = start ; j < end ; j++ ){
            if ( arr[j] <= pivit ){
                i++ ;

                int temp = arr[j] ;
                arr[j] = arr[i] ;
                arr[i] = temp ;
            }
        }

        i++ ;
        arr[end] = arr[i] ;
        arr[i] = pivit ;
        return i ;
    }
}
