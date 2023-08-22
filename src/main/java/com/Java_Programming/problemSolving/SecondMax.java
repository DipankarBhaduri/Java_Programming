package com.Java_Programming.problemSolving;

public class SecondMax {
    public static void main(String[] args) {
        int [] arr = {2,3,2,3,2,3,4,5,6,1,9};
        int secondMax = getSecondMaxElement(arr) ;
        System.out.println(secondMax);
    }
    public static int getSecondMaxElement ( int [] arr ){
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for ( int i = 0 ; i < arr.length ; i++ ){
            int currElement = arr[i] ;
            if ( currElement > firstMax ){
                secondMax = firstMax ;
                firstMax = currElement ;
            } else if ( currElement > secondMax ){
                secondMax = currElement ;
            }
        }

        return secondMax ;
    }
}
