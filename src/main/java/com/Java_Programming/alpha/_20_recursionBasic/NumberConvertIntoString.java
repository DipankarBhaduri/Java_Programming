package com.Java_Programming.alpha._20_recursionBasic;

public class NumberConvertIntoString {
    public static void main(String[] args) {
        int number = 19047 ;
        String [] string = {"zero" , "one" , "two" , "three" , "four" , "five" , "six" ,
                "seven" , "eight" , "nine" } ;
        int modifiedNumber = 0 ;
        while ( number > 0 ){
            int rem = number % 10 ;
            modifiedNumber = modifiedNumber * 10 + rem ;
            number = number / 10 ;
        }
        String response = convertNumberIntoString(modifiedNumber,string) ;
        System.out.println(response);
    }
    public static String convertNumberIntoString ( int number , String[] string ){
        if ( number == 0) {
            return "" ;
        }
        int rem = number % 10 ;
        return string[rem] +" "  + convertNumberIntoString(number/10 , string) ;
    }
}
