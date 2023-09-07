package com.Java_Programming.coreJava.java8Streams.practiceProblem_04_09_2023;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.stream.Collectors;

public class CalculateAvgAge {
    /**
     * @Questions : Calculate the average age of a list of Person objects using Stream operations
     * @param args
     */
    public static void main(String[] args) {
        PersonObject p1 = new PersonObject(22, "Dipankar");
        PersonObject p2 = new PersonObject(24, "Pritam");
        PersonObject p3 = new PersonObject(28, "Ajay");
        PersonObject p4 = new PersonObject(22, "Shivam");
        LongSummaryStatistics longSummaryStatistics = getAvgAge (Arrays.asList(p1, p2, p3, p4));
        System.out.println(longSummaryStatistics.getAverage());

    }

    private static LongSummaryStatistics getAvgAge(List<PersonObject> personObjects) {
        return personObjects.stream().collect(Collectors.summarizingLong(PersonObject::getAge));
    }
}

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class PersonObject {
    private int age;
    private String name;
}
