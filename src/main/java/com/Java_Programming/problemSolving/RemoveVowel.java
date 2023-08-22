package com.Java_Programming.problemSolving;

import java.util.HashMap;
import java.util.Map;

public class RemoveVowel {
    public static void main(String[] args) {
        String str = "i love gurgaon" ;
        String response = removeVowel(str) ;
        System.out.println(response);
        Map<String,String> map = new HashMap<>() ;
        map.put("abc" , "abc") ;
        String some = map.get("123456") ;
    }

    public static String removeVowel(String str ){
        //base case where str is empty
        if ( str.isEmpty()){
            return "" ;
        }

        if (str.charAt(0) == 'a' || str.charAt(0) == 'e' || str.charAt(0) == 'i' || str.charAt(0) == 'o' || str.charAt(0) == 'u' ){
            return removeVowel(str.substring(1)) ;
        } else {
            return str.substring(0,1).concat(removeVowel(str.substring(1))) ;
        }
    }
}
