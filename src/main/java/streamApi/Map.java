package streamApi;

import java.util.List;
import java.util.stream.Collectors;

public class Map {
    public static void main(String[] args) {
        student s1 = new student("Dipankar", 25 , "Btech") ;
        student s2 = new student("Suvodeep", 24 , "Btech") ;
        student s3 = new student("Arijit", 25 , "Btech") ;
        student s4 = new student("Saheb", 26 , "Diploma") ;

        List<student> studentList = List.of(s1,s2,s3,s4) ;

        List<Integer> ages = studentList.stream().map(student::getAge).collect(Collectors.toList()) ;
        ages.stream().forEach(age -> System.out.print(age+" "));
    }
}
