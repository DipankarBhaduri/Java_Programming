package com.Java_Programming.alpha._19_objectOrientedProgramming;

import lombok.Getter;
import lombok.Setter;

public class Inheritance {
    public static void main(String[] args) {
        Teacher s1 = new Teacher() ;
        s1.performance();
    }
}

class Principal {
    Principal(){
        System.out.println("Principal is a very intelligent person");
    }

    void performance (){
        System.out.println("Principal performance is good!");
    }
}

@Getter
@Setter
class Student extends Principal{
    String name ;
    int Id ;
    Student ( ){
        super();
        System.out.println("Student Constructor called");
        System.out.println("Student Constructor called");
        System.out.println("Student Constructor called");
    }


}


@Getter
@Setter
class Teacher extends Student {
   Teacher(){
       super();
       System.out.println("Teacher constractor called");
   }
}