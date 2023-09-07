package com.Java_Programming.learning.alpha._16_2DArray;

public class PrintTheNumberCount {
    public static void main(String[] args) {
        int [][] matrix = {
                {1,2,3,4,5},
                {5,6,7,8,3},
                {1,2,3,4,3},
                {5,6,7,8,2},
                {5,6,7,8,2}
        };
        int target = 2 ;
        int count = countPrintTheNumber(matrix , target) ;
        System.out.println(count);
    }
    public static int countPrintTheNumber ( int [][] matrix , int target ){
        int count = 0 ;
        for ( int i = 0 ; i < matrix.length ; i++ ){
            for ( int j = 0 ; j < matrix[0].length ; j++ ){
                if ( matrix[i][j] == target ){
                    count++ ;
                }
            }
        }

        return count ;
    }

}
