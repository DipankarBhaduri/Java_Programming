package com.Java_Programming.recursion;

import java.util.Scanner;

public class PrintOneToTen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        int n = sc.nextInt();
        printFromNToOne(n);
    }

    public static void printFromNToOne ( int val ){
        if ( val == 0 ){
            return ;
        } else {
            System.out.println(val);
        }
        printFromNToOne(val-1);
    }
}
