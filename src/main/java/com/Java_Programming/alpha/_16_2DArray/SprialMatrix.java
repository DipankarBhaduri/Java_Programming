package com.Java_Programming.alpha._16_2DArray;

public class SprialMatrix {
    public static void main(String[] args) {
        int [][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        printSprialMatrix(matrix);
    }
    public static void printSprialMatrix ( int [][] matrix){
        int startRow = 0 ;
        int endRow = matrix.length - 1 ;
        int startCol = 0 ;
        int endCol = matrix[0].length - 1 ;

        while ( startRow <= endRow && startCol <= endCol ){
            for ( int j = startCol ; j <= endCol ; j++ ){
                System.out.print(matrix[startRow][j]+" ");
            }
            startRow++ ;

            for ( int i = startRow ; i <= endRow ; i++ ){
                System.out.print(matrix[i][endCol]+" ");
            }
            endCol--;

            if ( startRow <= endRow) {
                for (int j = endCol; j >= startCol; j--) {
                    System.out.print(matrix[endRow][j] + " ");
                }
                endRow--;
            }

            for (int i = endRow; i >= startRow; i--) {
                System.out.print(matrix[i][startCol] + " ");
            }
            startCol++;
        }
    }
}
