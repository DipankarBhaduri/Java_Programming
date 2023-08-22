package com.Java_Programming.coreJava.java8Streams;

import java.util.ArrayList;
import java.util.List;

public class FlatMap {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("Dipankar" ,
                "Pritam" , "Suvodeep" , "Arijit" , "Souvik" ,
                "Surja" , "saheb")) ;

        list.stream().filter( string -> !string.equals("saheb")).forEach(System.out::println);

        int x = 3 ;
        int y = 2 ;
        for ( int i = 1 ; i < 5 ; i++ ){
            if ( i < --x || y++ > i ){
                y++ ;
                i += 1 ;
            }
        }
        System.out.println( x +" "+ y );


    }
}




