package com.Java_Programming.alpha._16_2DArray;

public class SearchInShortedMatrix {
    public static void main(String[] args) {
        int [][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,12,13,14},
                {13,14,15,16}
        };
        int target = 10 ;
        boolean response = targetSearchInShortedMatrix(matrix , target) ;
        System.out.println(response);
    }
    public static boolean targetSearchInShortedMatrix ( int [][] matrix , int target ){
        int rowStart = 0 ;
        int rowEnd = matrix.length - 1 ;
        int colStart = 0 ;
        int colEnd = matrix[0].length - 1 ;

        /*
             Searching using stairCase method ;
         */

        while (  rowStart >= 0 && rowStart < matrix.length && rowEnd >= 0 && rowEnd < matrix.length &&
        colStart >= 0 && colStart < matrix[0].length && colEnd >= 0 && colEnd < matrix[0].length ){
            int topRight = matrix[rowStart][colEnd] ;
             if ( topRight == target ) {
                 return  true ;
             }
             if ( target > topRight ){
                 rowStart++ ;
             } else if ( target < topRight ){
                 colEnd--;
             }
        }

        return false ;
    }
}
