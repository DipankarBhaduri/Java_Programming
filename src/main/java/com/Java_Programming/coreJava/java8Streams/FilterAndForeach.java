package com.Java_Programming.coreJava.java8Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FilterAndForeach {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("Dipankar" ,
                "Pritam" , "Suvodeep" , "pritam" , "Arijit" , "Souvik" ,"pritam" , "Arijit" , "Souvik" ,
                "Surja" , "saheb")) ;

        list.stream().filter(name -> name.equals("pritam")).forEach(System.out::println);

        System.out.println("-- -- -- -- -- -- -->");
        List<String> newSortedList = list.stream()
                .filter(string -> !(string.charAt(0) >= 'A'
                        && string.charAt(0) <='Z'))
                .collect(Collectors.toList());

        list.stream()
                .forEach(string -> System.out.println(string.toUpperCase()));

        System.out.println(list);

        newSortedList.stream().forEach(System.out::println);
         List<String> uniqueName = list.stream()
                 .filter(name -> (name.startsWith("s") || name.startsWith("S") || name.startsWith("D") ||name.startsWith("A")))
                .distinct()
                .collect(Collectors.toList()) ;


    }
}
