package com.Java_Programming.recursion;

import java.util.Scanner;

public class findSumOfDigitsOfANumberUsingRecursion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in) ;
        int number = scanner.nextInt() ;
        int ans = returnFind_Sum_of_Digits_of_a_Number_usingRecursion(number) ;
        System.out.println(ans);
    }

    public static int returnFind_Sum_of_Digits_of_a_Number_usingRecursion ( int number ){
        if ( number == 0 ){
            return 0 ;
        }
        int rem = number % 10 ;
        return rem + returnFind_Sum_of_Digits_of_a_Number_usingRecursion(number/10) ;
    }
}
