package com.Java_Programming.trendingCompanies.google;

import java.util.Stack;

public class _20_valid_parentheses {
    /**
     * @Link : https://leetcode.com/problems/valid-parentheses/
     * @param args
     */
    public static void main(String[] args) {
        /**
         * @Example :
         *
         * Input: s = "()[]{}"
         * Output: true
         * Example 3:
         *
         * Input: s = "(]"
         * Output: false
         */
        String s = "()[]{}[)" ;
        boolean response = checkValidParentheses(s);
        System.out.println(response);
    }

    public static boolean checkValidParentheses (String s) {
        if (s == null || s.length() < 2 || s.length() % 2 != 0){
            return false;
        } else {
            Stack<Character> stack = new Stack<>();
            for (int i = 0 ; i < s.length() ; i++) {
                char ch = s.charAt(i);
                if (ch == '(' || ch == '{' || ch == '['){
                    if(ch =='('){
                        stack.push(')');
                    }else if(ch =='{'){
                        stack.push('}');
                    }else{
                        stack.push(']');
                    }
                }else{
                    if (stack.size() > 0){
                        if ( stack.peek() == ch ){
                            stack.pop();
                        }else{
                            return false;
                        }
                    }else{
                        return false;
                    }
                }
            }
            return stack.size() == 0;
        }
    }
}
