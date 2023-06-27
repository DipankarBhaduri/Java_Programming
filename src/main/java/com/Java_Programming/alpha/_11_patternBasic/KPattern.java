package com.Java_Programming.alpha._11_patternBasic;

import java.util.Scanner;

public class KPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        int line  = sc.nextInt() ;
        printKPattern(line) ;
    }
    public static void printKPattern ( int line ){
        for ( int i = 1  ; i <= line/2 + 1 ; i++ ){
            for ( int j = line/2 + 1 ; j >= i ; j-- ){
                System.out.print("* ");
            }
            System.out.println();
        }
        for ( int i = line/2 ; i >= 1 ;  i-- ){
            for ( int j = line/2 + 1 ; j >= i ; j-- ){
                System.out.print("* ");
            }
            System.out.println();
        }

    }
}
