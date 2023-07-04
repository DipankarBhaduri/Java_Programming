package com.Java_Programming.alpha._12_functions;

import java.util.Scanner;

public class BinaryToDecimal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in) ;
        int binary = scanner.nextInt() ;
        int ans = convertBinaryToDecimal(binary) ;
        System.out.println("Binary To Decimal of "+binary+" is : " +ans);
    }
    public static int convertBinaryToDecimal ( int binary ){
        if ( binary == 0 ){
            return 0 ;
        }
        if ( binary == 1 ){
            return 1 ;
        }

        int decimal = 0 ;
        int count  = 1 ;
        while ( binary > 0 ){
            int rem = binary % 10 ;
            if ( rem == 1 ){
                decimal += count ;
            }

            count *= 2 ;
            binary = binary / 10 ;
        }
        return decimal ;
    }
}
