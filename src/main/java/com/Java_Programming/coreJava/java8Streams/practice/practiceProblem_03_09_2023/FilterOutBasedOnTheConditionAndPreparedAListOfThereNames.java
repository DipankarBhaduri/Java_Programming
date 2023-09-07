package com.Java_Programming.coreJava.java8Streams.practice.practiceProblem_03_09_2023;

import com.Java_Programming.coreJava.java8Streams.practice.filter.Person;

import java.util.Arrays;
import java.util.List;

public class FilterOutBasedOnTheConditionAndPreparedAListOfThereNames {
    /**
     * @Question Filter and Map: Given a list of Person objects, filter out all persons with age greater than 25 and
     *           create a list of their names
     * @param args
     */
    public static void main(String[] args) {
        Person p1 = new Person(1,"Dipankar",26);
        Person p2 = new Person(2,"Pritam",25);
        Person p3 = new Person(3,"Dipankar",24);
        Person p4 = new Person(4,"Soubhik",27);
        Person p5 = new Person(5,"Dipankar", 24);

        List<String> names = getNamesFormPersonListWithAgeGreaterThen25 (Arrays.asList(p1, p2, p3, p4, p5));
        names.stream().forEach(System.out::println);
    }

    private static List<String> getNamesFormPersonListWithAgeGreaterThen25(List<Person> personList) {
        return personList
                .stream()
                .filter(person -> person.getAge() > 25)
                .map(Person::getName)
                .toList();
    }
}
