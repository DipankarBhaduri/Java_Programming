package com.Java_Programming.learning.coreJava.lambdaFunctions;

@FunctionalInterface
interface Show {
    void run();
}

@FunctionalInterface
interface Movie {
     void ticket(int price);
}

@FunctionalInterface
interface Train {
    int priceUpDown (int up, int down);
}

public class PrintAnyThing{
    public static void main(String[] args) {
        Show s = () -> { System.out.println("I am running");};
        s.run();

        Movie m = price -> System.out.println("Ticket price is : "+price);
        m.ticket(100);

        Train t = (up, down) -> up + down;
        int price = t.priceUpDown(300, 500);
        System.out.println("Total up & down price is : "+price);
    }
}