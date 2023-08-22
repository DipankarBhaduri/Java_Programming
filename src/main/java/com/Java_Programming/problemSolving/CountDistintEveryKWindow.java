package com.Java_Programming.problemSolving;

import java.util.Arrays;
import java.util.HashSet;

public class CountDistintEveryKWindow {
    public static void main(String[] args) {
        int [] arr = {2,3,2,3,2,3,4,5,6,1,9};
        int k = 4 ;
        int [] response = countDistintInEveryKWindow(arr,k) ;
        System.out.println(Arrays.toString(response));
    }

    public static int[] countDistintInEveryKWindow ( int[] arr , int k ){
        int [] ans = new int [arr.length - k ] ;
        if ( arr == null || k > arr.length || k == 0 ){
            return ans ;
        }

        int startIndex = 0 ;
        int endIndex = k - 1 ;
        int index = 0 ;
        while ( endIndex != arr.length - 1 ){
            ans[index++] = getDistintCount(arr,startIndex++ , endIndex++ ) ;
        }
        return ans ;
    }

    public static int getDistintCount ( int[] arr , int startIndex , int endIndex ){
        HashSet<Integer> hashSet = new HashSet<>() ;
        while ( startIndex != endIndex+1 ){
            hashSet.add(arr[startIndex++]) ;
        }

        return hashSet.size() ;
    }
}

