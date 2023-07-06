package com.Java_Programming.alpha._16_2DArray;

public class SumOfTheNumbersInTheSecondRow {
    public static void main(String[] args) {
        int [][] matrix = {
                {1,2,3,4,5},
                {5,6,7,8,3},
                {1,2,3,4,3},
                {5,6,7,8,2},
                {5,6,7,8,2}
        };

        int sumOf2ndRow = findSumOfTheNumbersInTheSecondRow(matrix) ;
        System.out.println(sumOf2ndRow);
    }
    public static int findSumOfTheNumbersInTheSecondRow ( int[][] matrix ){
        int sum = 0 ;
        for ( int i = 0 ; i < matrix[0].length ; i++ ){
            sum += matrix[2+1][i] ;
        }
        return sum ;
    }
}
