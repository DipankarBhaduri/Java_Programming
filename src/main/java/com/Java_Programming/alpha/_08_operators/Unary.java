package com.Java_Programming.alpha._08_operators;

public class Unary {
    public static void main(String[] args) {
        int x = 1 ;
        int y = 1 ;
        for ( int i = 0 ; i < 5 ; i++ ){
            if ( i >= 3 || x++ > i ){
                x++ ;
                y++ ;
            }
        }
        System.out.println(x);
        System.out.println(y);
    }
}
