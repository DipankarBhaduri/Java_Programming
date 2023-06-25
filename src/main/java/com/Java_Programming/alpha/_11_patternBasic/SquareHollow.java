package com.Java_Programming.alpha._11_patternBasic;

import java.util.Scanner;

public class SquareHollow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        int line = sc.nextInt() ;
        printSquareHollowPattern(line);
    }
    public static void printSquareHollowPattern ( int line ){
        for ( int i = 1 ; i <= line ; i++ ){
            for ( int j = 1 ; j <= line ; j++ ){
                if ( i == 1 || i == line ){
                    System.out.print("*  ");
                } else if ( j == 1 || j == line ){
                    System.out.print("*  ");
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
    }
}
