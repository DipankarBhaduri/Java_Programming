package com.Java_Programming.learning.alpha._07_variablesAndDatatypes;

public class TypePromotion {
    public static void main(String[] args) {
        int a = 24 ;
        float b = 25.12f ;
        long c = 233333333;
        double d = 24.89 ;

        float ans = a+b+c+(float)d ;
        System.out.println(ans);
    }
}
