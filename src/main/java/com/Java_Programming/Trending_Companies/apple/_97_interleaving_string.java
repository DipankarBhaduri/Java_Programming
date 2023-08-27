package com.Java_Programming.Trending_Companies.apple;

public class _97_interleaving_string {
    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        System.out.println(isInterleave(s1,s2,s3));
    }
    public static boolean isInterleave(String s1, String s2, String s3) {
        if ( s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0 ||
                s3 == null || s3.length() == 0 ){
            return true ;
        }

        if ( s1.length() == 1 && s2.length() == 1 && s3.length() == 2 ){
            return true ;
        }

        int s1Length = 0 ;
        int s2Length = 0 ;
        int s3Length = 0 ;

        while (s3Length != s3.length()){
            if ( s2.length() != s2Length && s3.charAt(s3Length) == s2.charAt(s2Length)){
                s3Length++;
                s2Length++;
            }else if ( s1.length() != s1Length && s3.charAt(s3Length) == s1.charAt(s1Length)  ){
                s3Length++;
                s1Length++;
            }else{
                return false;
            }
        }
        return true;
    }
}
