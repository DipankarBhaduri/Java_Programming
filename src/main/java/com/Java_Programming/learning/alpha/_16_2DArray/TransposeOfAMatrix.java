package com.Java_Programming.learning.alpha._16_2DArray;

public class TransposeOfAMatrix {
    public static void main(String[] args) {
        int [][] matrix = {
                {1,2,3,4,5},
                {5,6,7,8,3},
        };

        int[][] ans = perfromTransposeOfAMatrix(matrix) ;
        for ( int i = 0 ; i < ans.length ; i++ ){
            for ( int j = 0 ; j < ans[0].length ; j++ ){
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static int[][] perfromTransposeOfAMatrix ( int[][] matrix) {
       int i = matrix.length ;
       int j = matrix[0].length ;
       int[][] newMatrix = new int[j][i] ;
       for ( int row = 0 ; row < matrix.length ; row++ ){
           for ( int col = 0 ; col < matrix[0].length ; col++ ){
               newMatrix[col][row] = matrix[row][col] ;
           }
       }
       return newMatrix ;
    }
}
