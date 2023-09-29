package com.Java_Programming.learning.leetCode;

import java.util.Stack;

public class _0067_add_binary {
    public static void main(String[] args) {
        String a = "1010", b = "1011";
        String ans = Solution.addBinary(a, b);
        System.out.println(ans);
    }
}

class Solution {
    public static String addBinary(String a, String b) {
        int st = a.length() - 1;
        int nd = b.length() - 1;
        char carry = '0';
        Stack<Character> stk = new Stack<>();

        while (st >= 0 || nd >= 0 || carry != '0') {
            int temp = 0;
            if(st >= 0) {
                temp += (int)(a.charAt(st) - '0');
                st--;
            }
            if(nd >= 0) {
                temp += (int)(b.charAt(nd) - '0');
                nd--;
            }
            temp += (int)(carry - '0');
            if(temp == 2) {
                stk.push('0');
                carry = '1';
            } else if(temp == 1){
                stk.push('1');
                carry = '0';
            } else {
                stk.push('0');
            }
        }

        if(carry != '0'){
            stk.push(carry);
        }
        String ans = "";
        while(!stk.isEmpty()) {
            ans += stk.peek();
            stk.pop();
        }
        return ans;
    }
}