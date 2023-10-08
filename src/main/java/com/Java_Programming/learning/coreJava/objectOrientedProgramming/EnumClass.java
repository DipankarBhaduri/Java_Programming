package com.Java_Programming.learning.coreJava.objectOrientedProgramming;

public class EnumClass {
    public static void main(String[] args) {
        Status status = Status.FINISHED;
        
        switch (status) {
            case STARTED -> System.out.println("status = " + status);
            case ONGOING -> System.out.println("status = " + status);
            case FINISHED -> System.out.println("status = " + status);
        }
        
        for ( Status s : Status.values()) {
            System.out.println("s = " + s);
        }
    }
}

enum Status {
    STARTED, ONGOING, FINISHED, YET_TO_START,
}