package com.Java_Programming.learning.alpha._20_recursionBasic;

public class FindFactorialOfN {
    public static void main(String[] args) {
        int n = 6 ;
        int answer = getFactorialOfN(n) ;
        System.out.println(answer);
    }

    public static int getFactorialOfN ( int n ){
        if ( n == 0 ){
            return 1 ;
        }
        return n * getFactorialOfN(n - 1 ) ;
    }
}
