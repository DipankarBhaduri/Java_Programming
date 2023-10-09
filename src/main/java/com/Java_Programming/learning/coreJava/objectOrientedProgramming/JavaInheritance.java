package com.Java_Programming.learning.coreJava.objectOrientedProgramming;

public class JavaInheritance {
    public static void main(String[] args) {
        Car car = new Car();
        car.modelName = "B-M-W";
        System.out.println(car.modelName);
    }
}

class Vehicle {
    String brand = "Ford";
    public void honk() {
        System.out.println("Tuut, tuut!");
    }
}

class Car extends Vehicle {
    String modelName = "Mustang";
}