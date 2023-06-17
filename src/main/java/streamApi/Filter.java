package streamApi;

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

        student s1 = new student("Dipankar", 25 , "Btech") ;
        student s2 = new student("Suvodeep", 24 , "Btech") ;
        student s3 = new student("Arijit", 25 , "Btech") ;
        student s4 = new student("Saheb", 26 , "Diploma") ;

        List<String> names = List.of("Dipankar","Saheb") ;

        List<student> studentList = List.of(s1,s2,s3,s4) ;

        List<student> students = studentList.stream()
                .filter( student -> names.contains(student.getName())).collect(Collectors.toList()); ;

        students.stream().forEach(student -> System.out.println(student.getName()));
    }
}


class student {
    String name ;
    int age ;
    String qualification ;

    student ( String name , int age , String qualification ){
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