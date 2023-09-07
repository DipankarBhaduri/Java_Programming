package com.Java_Programming.learning.alpha._20_recursionBasic;

public class LastOccurrence {
    public static void main(String[] args) {
        int [] arr = { 5,4,3,6,7,9,3,1} ;
        int target = 12 ;
        int n = arr.length  - 1 ;
        int response = getLastOccurrence(arr , target , n) ;
        System.out.println(response);
    }
    public static int getLastOccurrence ( int [] arr , int target , int index ){
        if ( index == - 1 ){
            return  - 1 ;
        }

        if ( arr[index] == target ){
            return index ;
        } else {
            return getLastOccurrence(arr ,target ,index-1) ;
        }
    }
}
