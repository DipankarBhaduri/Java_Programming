package com.Java_Programming.streamApi;

import java.util.List;
import java.util.stream.Collectors;

public class Filter {
    public static void main(String[] args) {
        List<String> stringList = List.of("Dipankar","Dipu","Dipan","Santra","shubho") ;
        List<String> ans = stringList.stream()
                .filter(name -> name.substring(name.length()-1)
                        .toLowerCase()
                        .equals("o"))
                .collect(Collectors.toList()) ;
        ans.stream().forEach(name -> System.out.print(name+" "));
        System.out.println();

        Student s1 = new Student("Dipankar", 25 , "Btech") ;
        Student s2 = new Student("Suvodeep", 24 , "Btech") ;
        Student s3 = new Student("Arijit", 25 , "Btech") ;
        Student s4 = new Student("Saheb", 26 , "Diploma") ;

        List<String> names = List.of("Dipankar","Saheb") ;

        List<Student> studentList = List.of(s1,s2,s3,s4) ;

        List<Student> Students = studentList.stream()
                .filter(Student -> names.contains(Student.getName())).collect(Collectors.toList()); ;

        Students.stream().forEach(Student -> System.out.println(Student.getName()));
    }
}


class Student {
    String name ;
    int age ;
    String qualification ;

    Student(String name , int age , String qualification ){
        this.name =name ;
        this.age = age ;
        this.qualification = qualification ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
}