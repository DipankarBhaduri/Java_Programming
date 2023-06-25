package com.Java_Programming.alpha._11_patternBasic;

import java.util.Scanner;

public class NumberTriangular {
    public static void main(String[] args) {
        Scanner sc = new Scanner ( System.in) ;
        int line = sc.nextInt() ;
        printNumberTriangular(line);
    }
    public static void printNumberTriangular ( int line ){
        for ( int i = 1 ; i <= line ; i++ ){
            for ( int j = i+1 ; j <= line ; j++ ){
                System.out.print(" ");
            }

            for ( int k = 1 ; k <= i ; k++ ){
                System.out.print(i+" ");
            }

            System.out.println();
        }
    }
}
