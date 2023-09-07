package com.Java_Programming.learning.coreJava.java8Streams.practice.filter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ObjectToStringBasedOnTheCase {
    public static void main(String[] args) {
        Person p1 = new Person(1,"Dipankar",26);
        Person p2 = new Person(2,"Pritam",25);
        Person p3 = new Person(3,"Dipankar",24);
        Person p4 = new Person(4,"Soubhik",27);
        Person p5 = new Person(5,"Dipankar", 24);

        System.out.println("---------"+"Find Id Or Age"+"------------");
        List<Integer> integerList = findIdOrAge(Arrays.asList(p1, p2, p3, p4, p5), "Dipankar", 24);
        integerList.stream().forEach(System.out::println);


        System.out.println("---------"+"Count Above Or Equal Age"+"------------");
        int count = countAboveOrEqualAge(Arrays.asList(p1, p2, p3, p4, p5), 24);
        System.out.println(count);
    }


    /**
     * Counts the number of persons with an age greater than or equal to the given age.
     * @param personList List of Person objects
     * @param age Age to compare against
     * @return Count of persons with age greater than or equal to the given age
     */
    private static int countAboveOrEqualAge(List<Person> personList, int age) {
        return (int)personList.stream().filter(person -> (person.getAge() >= 25)).count();
    }


    /**
     * Finds the IDs of persons with a specific name and age.
     * @param personList List of Person objects
     * @param name Name to compare against
     * @param age Age to compare against
     * @return List of IDs of persons matching the given name and age
     */
    public static List<Integer> findIdOrAge (List<Person> personList, String name, int age) {
        return personList.stream()
                .filter(person -> (age == person.getAge() && name.equals(person.getName())))
                .map(Person::getId)
                .collect(Collectors.toList());
    }
}
