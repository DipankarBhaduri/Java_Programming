package com.Java_Programming.learning.alpha._09_conditions;

public class SwitchStatement {
    public static void main(String[] args) {
        String month = "FEB" ;

        switch (month){
            case "JAN" :
                System.out.println("January");
                break;

            case "FEB" :
                System.out.println("Febrary");
                break;

            case "MAR" :
                System.out.println("March");

            default :
                System.out.println("Not a Month");
        }
    }
}
