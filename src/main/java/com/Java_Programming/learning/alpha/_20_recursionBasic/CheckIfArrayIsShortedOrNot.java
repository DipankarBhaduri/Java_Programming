package com.Java_Programming.learning.alpha._20_recursionBasic;

public class CheckIfArrayIsShortedOrNot {
    public static void main(String[] args) {
        int [] arr = { 1,2,3,4,3} ;
        boolean response = getCheckIfArrayIsShortedOrNot(arr,0) ;
        System.out.println(response);
    }

    public static boolean getCheckIfArrayIsShortedOrNot ( int [] arr , int index ){
        if ( index == arr.length - 1 ){
            return true ;
        }
        if ( index < arr.length - 1 && arr[index] < arr[index+1]){
            return true && getCheckIfArrayIsShortedOrNot(arr , index+1) ;
        } else {
            return false ;
        }
    }
}
