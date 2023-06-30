package com.Java_Programming.alpha._11_patternBasic;

import java.util.Scanner;

public class PascalsTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in) ;
        int line = sc.nextInt() ;
        printPascalsTriangle(line);
    }

    public static void printPascalsTriangle ( int line ){
        for ( int i = 1 ; i <= line ; i++ ){
            for ( int j = 1 ; j <= line - i ; j++ ){
                System.out.print(" ");
            }
            for ( int j = 1 ; j < 2 * i ; j++ ){
                if ( j == 1 || j == 2 * i - 1 ){
                    System.out.print(1);
                } else if ( j % 2 != 0 ){
                    System.out.print(i-1);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
