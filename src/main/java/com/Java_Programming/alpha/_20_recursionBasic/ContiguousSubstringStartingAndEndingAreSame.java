package com.Java_Programming.alpha._20_recursionBasic;

public class ContiguousSubstringStartingAndEndingAreSame {
    public static void main(String[] args) {
        String str = "abcab" ;
        int count = countContiguousSubstringStartingAndEndingAreSame(str) ;
        System.out.println(count);
    }
    public static int countContiguousSubstringStartingAndEndingAreSame ( String str ){
        if ( str.length() == 0 ){
            return 0 ;
        }
        int count = 0 ;
        for ( int i = 1 ; i <= str.length() ; i++ ){
            String curr = str.substring(0,i) ;
            if ( curr.charAt(0) == curr.charAt(curr.length() - 1)){
                count++ ;
                System.out.println(curr);
            }
        }

        return count + countContiguousSubstringStartingAndEndingAreSame(str.substring(1)) ;
    }

}
