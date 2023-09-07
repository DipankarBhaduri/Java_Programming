package com.Java_Programming.learning.alpha._23_backTracking;

public class FindPermutations {
    public static void main(String[] args) {
        String str = "abcd";
        findAllPermutations(str, new String());
    }
    public static void findAllPermutations(String str, String ans){
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String newString = str.substring(0, i) + str.substring(i+1);
            findAllPermutations(newString, ans+ch);
        }
    }
}
