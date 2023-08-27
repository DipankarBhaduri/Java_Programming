package com.Java_Programming.alpha._23_backTracking;

public class FindSubsets {
    public static void main(String[] args) {
        String str = "ab";
        findSubsetUsingBacktracking(str,0,new String());
    }
    public static void findSubsetUsingBacktracking(String str, int i, String ans ) {
        if (i == str.length()) {
            if (ans.length() != 0) {
                System.out.println(ans);
            }
            return;
        }

        findSubsetUsingBacktracking(str,i+1,ans+str.charAt(i));
        findSubsetUsingBacktracking(str,i+1, ans);
    }
}
