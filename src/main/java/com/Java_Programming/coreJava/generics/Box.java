package com.Java_Programming.coreJava.generics;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Box<T> {
    T container ;
    public Box ( T container  ){
        this.container = container ;
    }
}
