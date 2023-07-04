package com.Java_Programming.alpha._16_2DArray;

public class DiagonalSum {
    public static void main(String[] args) {
        int [][] matrix = {
                {1,2,3,4,5},
                {5,6,7,8,3},
                {1,2,3,4,3},
                {5,6,7,8,2},
                {5,6,7,8,2}
        };

        int diagonalSum = getDiagonalSum(matrix) ;
        if ( matrix.length % 2 != 0 && matrix[0].length % 2 != 0 ){
            diagonalSum -= matrix[(matrix.length / 2)][(matrix.length / 2)] ;
        }
        System.out.println(diagonalSum);
    }
    public static int getDiagonalSum ( int[][] matrix ){
        int diagonalSum = 0 ;
        int col = 0 ;
        int row = 0 ;
        while ( row < matrix.length && col < matrix[0].length){
            diagonalSum += matrix[row++][col++] ;
        }

        col = 0 ;
        row = matrix[0].length - 1 ;
        while ( col >= 0 && row >= 0 ){
            diagonalSum += matrix[row--][col++] ;
        }

        return diagonalSum ;
    }
}
