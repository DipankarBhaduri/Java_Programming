package com.Java_Programming.learning.alpha._14_arrays;

import java.util.HashSet;
import java.util.Scanner;

public class AppearsAtLeastTwiceInTheArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in) ;
        int length = scanner.nextInt();
        int [] arr = new int [length] ;
        for ( int i = 0 ; i < length ; i++ ){
            arr[i] = scanner.nextInt();
        }
        boolean ans = checkAppearsAtLeastTwiceInTheArray(arr) ;
        System.out.println(ans);
    }
    public static boolean checkAppearsAtLeastTwiceInTheArray ( int [] arr ){
        HashSet<Integer> integerHashSet = new HashSet<>();
        for ( int i = 0 ; i < arr.length ; i++ ){
            int value = arr[i] ;
            if (integerHashSet.contains(value)){
                return true ;
            }
            integerHashSet.add(value);
        }
        return false ;
    }
}
