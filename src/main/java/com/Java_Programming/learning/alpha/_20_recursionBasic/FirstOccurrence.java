package com.Java_Programming.learning.alpha._20_recursionBasic;

public class FirstOccurrence {
    public static void main(String[] args) {
        int[] arr = { 5,3,4,2,6,7,5,4,8,6,5,3,2,4,6} ;
        int target = 6 ;
        int ans = getFirstOccurrence(arr , target , 0) ;
        System.out.println(ans);
    }
    public static int getFirstOccurrence ( int [] arr , int target , int index ){
        if ( index == arr.length){
            return -1 ;
        }

        if ( arr[index] == target ){
            return index ;
        } else {
            return getFirstOccurrence(arr , target , index+1) ;
        }
    }
}
