package com.Java_Programming.alpha._12_functions;

import java.util.Scanner;
import java.util.Stack;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in) ;
        int decimal = scanner.nextInt() ;
        int binary = convertDecimalToBinary(decimal) ;
        System.out.println(binary);
    }
    public static int convertDecimalToBinary ( int decimal ){
        int binary = 0 ;
        Stack<Integer> stack = new Stack<>() ;
        while ( decimal > 0 ) {
            int rem = decimal % 2 ;
            stack.push(rem) ;
            decimal /= 2 ;
        }
        while ( !stack.isEmpty()){
            binary = binary*10+stack.pop() ;
        }
        return binary ;
    }
}
