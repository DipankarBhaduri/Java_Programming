package com.Java_Programming.learning.coreJava;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListClass {
    public static void main(String[] args) {
        Object o = "Dipankar";
        if(o instanceof String) {
            System.out.println("o = " + o);
        } else {
            System.out.println("Not a Integer");
        }
    }
}

class std {
    volatile String name;
    std (String name) {
        this.name = name;
    }
}
