package com.Java_Programming.learning.alpha._20_recursionBasic;

public class FindLengthOfAString {
    public static void main(String[] args) {
        String str = "dipankarBhaduri" ;
        int response = findLengthOfString(str) ;
        System.out.println(response);
    }
    public static int findLengthOfString ( String string) {
        if ( string.length() == 0 ){
            return 0 ;
        }

        return 1 + findLengthOfString(string.substring(1)) ;
    }
}
