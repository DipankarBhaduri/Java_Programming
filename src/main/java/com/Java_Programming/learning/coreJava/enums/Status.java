package com.Java_Programming.learning.coreJava.enums;

import lombok.NoArgsConstructor;
import java.util.Arrays;

@NoArgsConstructor
public enum Status {
    STARTED, INPROGRESS, PENDING, DONE,
}

class Usage{
    public static void main(String[] args) {
        Status s = Status.INPROGRESS;
        System.out.println(s.ordinal());
        System.out.println(s);
    }
}
