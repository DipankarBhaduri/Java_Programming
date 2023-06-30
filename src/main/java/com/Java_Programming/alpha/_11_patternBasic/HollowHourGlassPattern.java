package com.Java_Programming.alpha._11_patternBasic;

import java.util.Scanner;

public class HollowHourGlassPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        int line = sc.nextInt() ;
        printHollowHourGlassPattern(line);
    }
    public static void printHollowHourGlassPattern ( int line ){
        for ( int i = 1 ; i <= line ; i++ ){
              for ( int j = 2 ; j <= i ; j++ ){
                  System.out.print(" ");
              }

              for ( int j = 1 ; j <= 2*line - i  ; j++ ){
                  if ( i == 1 || j == 1 || j == 2*line - 2*i + 1 ){
                      System.out.print("*");
                  } else {
                      System.out.print(" ");
                  }
              }
            System.out.println();
        }
        for ( int i = line ; i >= 1 ;  i-- ){
            for ( int j = 2 ; j <= i ; j++ ){
                System.out.print(" ");
            }

            for ( int j = 1 ; j <= 2*line - i ; j++ ){
                if ( i == 1 || j == 1 || j == 2*line - 2*i + 1 ){
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
