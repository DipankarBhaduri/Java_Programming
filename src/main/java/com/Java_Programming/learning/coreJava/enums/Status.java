package com.Java_Programming.learning.coreJava.enums;

import lombok.NoArgsConstructor;
import java.util.Arrays;

@NoArgsConstructor
public enum Status {
    STARTED, INPROGRESS, PENDING, DONE,
}

class Usage{
    public static void main(String[] args) {
        String str = "getAllDataAsList";
        System.out.println(prepareFieldLabel(str));
    }

    class Solution {
        public static String removeOccurrences(String s, String part) {
            while (s.contains(part)) {
                s = s.replaceFirst(part, "");
            }
            return s;
        }
    }

    public static String prepareFieldLabel(String fieldName) {
        StringBuilder titleCase = new StringBuilder();
        for (int i = 0; i < fieldName.length(); i++) {
            char currentChar = fieldName.charAt(i);

            if (i == 0 || Character.isUpperCase(currentChar)) {
                if(i == 0) {
                    titleCase.append(Character.toUpperCase(currentChar));
                }else {
                    titleCase.append(' ');
                    titleCase.append(Character.toUpperCase(currentChar));
                }
            } else {
                titleCase.append(currentChar);
            }
        }
        return titleCase.toString();
    }
}

