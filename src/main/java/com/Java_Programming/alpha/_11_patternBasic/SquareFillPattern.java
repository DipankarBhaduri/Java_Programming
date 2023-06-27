package com.Java_Programming.alpha._11_patternBasic;

import java.util.Scanner;

public class SquareFillPattern {
    public static void main(String[] args) {
        Scanner sc= new Scanner( System.in) ;
        int line = sc.nextInt() ;
        printSquareFillPattern(line);
    }
    public static void printSquareFillPattern ( int line ){
        for ( int i = 1 ; i <= line ; i++ ){
            for ( int j = 1 ; j <= line ; j++ ){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
