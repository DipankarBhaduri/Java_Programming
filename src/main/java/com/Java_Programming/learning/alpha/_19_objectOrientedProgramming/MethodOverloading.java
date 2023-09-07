package com.Java_Programming.learning.alpha._19_objectOrientedProgramming;

public class MethodOverloading {
    public static void main(String[] args) {
        float sum = doSum(10 ,12 ,(float) 8.99);
        System.out.println(sum);
    }

    public static int doSum ( int num1 , int num2 ){
        return num1+num2 ;
    }
    public static float doSum ( int num1 , int num2 , float num3 ){
        return num1+num2+num3 ;
    }
    public static int doSum ( int num1 , int num2 , int num3 ){
        return num1+num2+num3 ;
    }
}
