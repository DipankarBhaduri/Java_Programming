package com.Java_Programming.alpha._11_patternBasic;

import java.util.Scanner;

public class HollowDiamondPyramid {
    public static void main(String[] args) {
        Scanner sc = new Scanner( System.in) ;
        int line = sc.nextInt() ;
        printHollowDiamondPyramid(line);
    }

    public static void printHollowDiamondPyramid ( int line ){
        for ( int i = 1 ; i <= line ; i++ ){
            for ( int j = 1 ; j < line - i + 1 ; j++ ){
                System.out.print(" ");
            }
            for ( int j = 1 ; j < 2*line ; j++ ){
                if( j == 1 || j == 2*i - 1 ){
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        for ( int i = line ; i >= 1 ;  i-- ){
            for ( int j = 1 ; j < line - i + 1 ; j++ ){
                System.out.print(" ");
            }
            for ( int j = 1 ; j < 2*line ; j++ ){
                if( j == 1 || j == 2*i - 1 ){
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
