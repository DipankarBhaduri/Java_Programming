package com.Java_Programming.basicShortingAlgo;

import java.util.Scanner;

public class MultiplecationTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner ( System.in) ;
        int number = sc.nextInt() ;
        for ( int i = 1 ; i<= 10 ; i++ ){
            System.out.println(number+" X "+ i + " = " + number*i);
        }
    }
}
