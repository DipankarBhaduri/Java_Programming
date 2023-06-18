package com.Java_Programming.streamApi;

import org.springframework.util.StopWatch;

import java.util.List;
import java.util.stream.Collectors;

public class Map {
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch() ;
        stopWatch.start();
        Student s1 = new Student("Dipankar", 25 , "Btech") ;
        Student s2 = new Student("Suvodeep", 24 , "Btech") ;
        Student s3 = new Student("Arijit", 25 , "Btech") ;
        Student s4 = new Student("Saheb", 26 , "Diploma") ;

        List<Student> studentList = List.of(s1,s2,s3,s4) ;

        List<Integer> ages = studentList.stream().map(Student::getAge).collect(Collectors.toList()) ;
        ages.stream().forEach(age -> System.out.print(age+" "));
        stopWatch.stop();
        System.out.println();
        System.out.println("Total time taken by excuting : "+stopWatch.getTotalTimeMillis()+" mili-Seconds");
    }
}
