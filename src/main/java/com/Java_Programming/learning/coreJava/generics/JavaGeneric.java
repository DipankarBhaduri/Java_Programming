package com.Java_Programming.learning.coreJava.generics;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class JavaGeneric {
    public static void main(String[] args) {

        Box<Boolean> box = new Box<>(true) ;
        System.out.println(box.getContainer());
        System.out.println(box.container.getClass().getName());

        List list = new ArrayList<>() ;
        list.add(1234) ;
        list.add("1234") ;
        list.add(true) ;

        HashSet hashSet = new HashSet() ;
        hashSet.add(123) ;
        hashSet.add("Good Morning") ;
        hashSet.add(true) ;
        hashSet.add(123) ;

        System.out.println(list);
        System.out.println(hashSet.contains("Good Morning"));
        System.out.println(hashSet.contains(123));
        System.out.println(hashSet.contains(true));
    }
}


