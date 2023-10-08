package com.Java_Programming.learning.coreJava.javaMath;


public class MathMethods {
    public static void main(String[] args) {
        int getRandomNumberInBetween0To100WhichIsDivisiableBy7 = getRandomNumber ();
        while(getRandomNumberInBetween0To100WhichIsDivisiableBy7 % 7 != 0) {
            getRandomNumberInBetween0To100WhichIsDivisiableBy7 = getRandomNumber ();
            System.out.println("getRandomNumberInBetween0To100WhichIsDivisiableBy7 = " + getRandomNumberInBetween0To100WhichIsDivisiableBy7);
        }
        System.out.println("Done !!");
    }

    private static int getRandomNumber() {
        return (int)(Math.random() * 101);
    }

    private static int getAbsulateDifference(int n1, int n2) {
        return Math.abs(n1-n2);
    }

    private static Boolean checkSquareOrNot(int n) {
        return (Math.sqrt(n) % 1 == 0);
    }

    private static int getMaxValue(int n1, int n2) {
        return Math.max(n1, n2);
    }
}
