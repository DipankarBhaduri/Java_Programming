package com.Java_Programming.learning.coreJava.objectOrientedProgramming;

public class InnerClass {
    public static void main(String[] args) {
        Out out = new Out();
        Out.Inner inner = new Out.Inner();
        System.out.println(out.x);
        System.out.println(inner.y);
    }
}

class Out {
    int x = 10;
    static class Inner {
        int y = 5;
    }
}