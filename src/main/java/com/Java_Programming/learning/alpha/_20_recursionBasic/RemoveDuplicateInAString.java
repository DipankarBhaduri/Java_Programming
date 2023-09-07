package com.Java_Programming.learning.alpha._20_recursionBasic;

import java.util.HashSet;

public class RemoveDuplicateInAString {
    public static void main(String[] args) {
        String string = "aaapppnaaacccoollaagggee" ;
        HashSet<Character> hashSet = new HashSet<>() ;
        String response = removeDuplicateFromString(string , hashSet ) ;
        System.out.println(response);
    }

    public static String removeDuplicateFromString ( String string , HashSet<Character> hashSet ){
        if ( string.length() == 0 ){
            return "" ;
        }

        if ( !hashSet.contains(string.charAt(0))) {
            hashSet.add(string.charAt(0)) ;
            return string.substring(0,1)+ removeDuplicateFromString(string.substring(1), hashSet) ;
        } else {
           return removeDuplicateFromString(string.substring(1), hashSet) ;
        }
    }
}
