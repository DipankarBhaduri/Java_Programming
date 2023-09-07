package com.Java_Programming.coreJava.java8Streams.practice.practiceProblem_03_09_2023;

import com.Java_Programming.coreJava.java8Streams.practice.filter.Person;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterPersonGraterThenTarget {
    /**
     * @Question Filtering with Objects: Given a list of Person objects,
     *           filter out all persons with age greater than 30.
     * @param args
     */
    public static void main(String[] args) {
        Person p1 = new Person(1, "Dipankar", 25);
        Person p2 = new Person(1, "Devid", 35);
        Person p3 = new Person(1, "Markel Brusho", 45);
        Person p4 = new Person(1, "Jons", 31);

        List<Person> personList = getPersonListGraterThanTargetAge(Arrays.asList(p1, p2, p3, p4), 30);
        List<String> names = personList.stream().map(Person::getName).toList();
        names.stream().forEach(System.out::println);
    }

    public static List<Person> getPersonListGraterThanTargetAge (List<Person> personList, int age) {
        return personList.stream().filter(person -> age < person.getAge()).collect(Collectors.toList());
    }
}
