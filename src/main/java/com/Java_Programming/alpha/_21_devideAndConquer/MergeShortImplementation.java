package com.Java_Programming.alpha._21_devideAndConquer;

import java.util.Arrays;

public class MergeShortImplementation {
    public static void main(String[] args) {
        int [] arr = { 6,3,7,4,2,5} ;
        devide(arr , 0 , arr.length - 1 );
        System.out.println(Arrays.toString(arr));
    }

    public static void devide ( int[] arr , int start , int end ){
        if ( start >= end ){
            return;
        }

        int mid = start + (end - start) / 2 ;
        devide(arr , start , mid);
        devide(arr , mid+1 , end);
        merge(arr , start ,mid , end);
    }

    public static void merge ( int [] arr , int start , int mid , int end ){
        int [] temp = new int [end-start + 1 ] ;
        int i = start ;
        int j = mid+1 ;
        int k = 0 ;

        while ( i <= mid && j <= end ){
            if ( arr[i] < arr[j] ){
                temp [k] = arr[i] ;
                i++ ;
            } else {
                temp [k] = arr[j] ;
                j++ ;
            }
            k++ ;
        }

        while ( i <= mid ){
            temp[k++] = arr[i++] ;
        }

        while ( j <= end ){
            temp[k++] = arr[j++] ;
        }

        for ( k = 0 , i = start ; k < temp.length ; k++ , i++ ){
            arr[i] = temp[k] ;
        }
    }
}
