package com.Java_Programming.learning.coreJava.java8Streams.practice.filter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFilterByNameAndAge {
    public static void main(String[] args) {
        Person p1 = new Person(1,"Dipankar",26);
        Person p2 = new Person(2,"Pritam",25);
        Person p3 = new Person(3,"Dipankar",24);
        Person p4 = new Person(4,"Soubhik",27);
        Person p5 = new Person(5,"Dipankar", 24);
        List<Person> personList = Arrays.asList(p1, p2, p3, p4, p5);
        List<Person> filteredList = filterByNameAndAge(personList, "Dipankar" , 26);
        filteredList.stream().forEach(person -> {
            System.out.println(person.getId()+"-"+person.getName()+"-"+person.getAge());
        });
    }

    /**
     *
     * @param personList
     * @param name
     * @param age
     * @return
     */
    public static List<Person> filterByNameAndAge (List<Person> personList, String name, int age) {
        return personList.parallelStream().filter(person -> (person.getName().equals(name) &&
                person.getAge()==age)).collect(Collectors.toList());
    }


}
