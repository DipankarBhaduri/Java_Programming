package com.Java_Programming.leetCode;

import java.util.Scanner;

public class StringConcat {
    public static void main(String[] args) {
        Scanner sc = new Scanner ( System.in) ;
        String str = sc.nextLine() ;
        String ans = stringConcat(str) ;
        System.out.println(ans);
    }

    public static String stringConcat ( String str ){
        StringBuilder sb = new StringBuilder("") ;
        String curr = "" ;
        for ( int i = 0 ; i < str.length() ; i++ ){
            char ch = str.charAt(i) ;
            if ( ch >= 'A' && ch <='Z' ) {
                sb.append(curr) ;
                sb.append(" ") ;
                curr = "" ;
                curr += ch ;
            } else {
                if ( i == 0 ){
                    String Str1 = ""+ch ;
                    curr += Str1.toUpperCase() ;
                } else {
                    curr += ch ;
                }
            }
        }
        sb.append(curr) ;
        return sb.toString();
    }
}
