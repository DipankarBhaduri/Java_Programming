package com.Java_Programming.alpha._11_patternBasic;

import java.util.Scanner;

public class HollowTrianglePattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in) ;
        int line = sc.nextInt() ;
        printHollowTrianglePattern(line);
    }
    public static void printHollowTrianglePattern ( int line ){
        for ( int i = 1 ; i <= line ; i++ ){
            for ( int j = i ; j <= line ; j++ ){
                System.out.print(" ");
            }
            for ( int j = 1 ; j < 2*i ; j++ ){
                if ( j == 1 || j == 2*i-1 || i == line){
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
