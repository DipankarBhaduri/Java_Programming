package com.Java_Programming.alpha._19_objectOrientedProgramming;

public class MethodOverwriting {
    public static void main(String[] args) {
        Tiger tiger = new Tiger() ;
        tiger.walk();
        tiger.eat();
    }
}

interface Animal {
    void walk() ;
    void eat() ;
}

class Tiger implements Animal {

    @Override
    public void walk() {
        System.out.println("Tiger can walk using 4 legs");
    }

    @Override
    public void eat() {
        System.out.println("Tiger can eat chicken");
    }
}

