package com.Java_Programming.alpha._11_patternBasic;

import java.util.Scanner;

public class MirrorImageTrianglePattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        int line = sc.nextInt() ;
        printMirrorImageTrianglePattern(line);
    }
    public static void printMirrorImageTrianglePattern ( int line ){
        for ( int i = 1 ; i <= line - 1  ; i++ ){
            for ( int j = 2 ; j <= i ; j++ ){
                System.out.print(" ");
            }
            for ( int j = i ; j <= line ; j++ ){
                System.out.print(j+" ");
            }
            System.out.println();
        }
        for ( int i = line ; i >= 1 ; i-- ){
            for ( int j = 2 ; j <= i ; j++ ){
                System.out.print(" ");
            }
            for ( int j = i ; j <= line ; j++ ){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}
