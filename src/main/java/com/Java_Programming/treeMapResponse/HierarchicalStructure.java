package com.Java_Programming.treeMapResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/get")
public class HierarchicalStructure {

    @GetMapping("/all")
    public Object getHierarchicalStructureResponse (){
        Student student1 = new Student("Dipankar", 25  , 3 ) ;
        Student student2 = new Student("Sujay", 26  , 3 ) ;
        Student student3 = new Student("Srimanta", 25  , 3 ) ;
        Student student4 = new Student("Jaydev", 25  , 3 ) ;
        Student student5 = new Student("Mrinmay", 25  , 3 ) ;

        Teacher teacher1 = new Teacher("Kamalesh", 40 , 2 ) ;
        Teacher teacher2 = new Teacher("Sudipta", 44 , 2 ) ;
        Teacher teacher3 = new Teacher("Rajesh", 36 , 2 ) ;

        Principal principal1 = new Principal("SubhankarPaul", 47 , 1) ;

        Role role1 = new Role("Madyamik" , student1 , teacher1 , principal1 ) ;
        Role role2 = new Role("Madyamik" , student2 , teacher2 , principal1 ) ;
        Role role3 = new Role("Madyamik" , student3 , teacher1 , principal1 ) ;
        Role role4 = new Role("Madyamik" , student1 , teacher3 , principal1 ) ;
        Role role5 = new Role("HigherSecondary" , student4 , teacher2 , principal1 ) ;
        Role role6 = new Role("HigherSecondary" , student5 , teacher2 , principal1 ) ;
        Role role7 = new Role("HigherSecondary" , student2 , teacher1 , principal1 ) ;

        List<Role> roleList = List.of(role1,role2,role3,role4,role5,role6,role7) ;

        Map<String,Object> result = new HashMap<>() ;


        for ( Role role : roleList ){
            String roleName = role.getName();
            if (!result.containsKey(roleName)) {
                Map<String, Object> principalMap = new HashMap<>();
                Map<String, Map<String, Object>> teacherMap = new HashMap<>();
                Map<String, Object> studentMap = new HashMap<>();

                studentMap.put(role.getStudent().getName(), role.getStudent());
                teacherMap.put(role.getTeacher().getName(), studentMap);
                principalMap.put(role.getPrincipal().getName(), teacherMap);

                result.put(roleName, principalMap);
            } else {
                Map<String, Object> principalMap = (Map<String, Object>) result.get(roleName);
                Map<String, Map<String, Object>> teacherMap = (Map<String, Map<String, Object>>) principalMap.get(role.getPrincipal().getName());
                if (teacherMap == null) {
                    teacherMap = new HashMap<>();
                    principalMap.put(role.getPrincipal().getName(), teacherMap);
                }

                Map<String, Object> studentMap = teacherMap.get(role.getTeacher().getName());
                if (studentMap == null) {
                    studentMap = new HashMap<>();
                    teacherMap.put(role.getTeacher().getName(), studentMap);
                }

                studentMap.put(role.getStudent().getName(), role.getStudent());
            }
        }

        return roleList ;
    }


    @Getter
    @Setter
    @AllArgsConstructor
    class Role {
        private  String name ;
        private Student student ;
        private Teacher teacher ;
        private Principal principal ;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    class Student {
        private String name ;
        private int age ;
        private int level ;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    class Teacher {
        private String name ;
        private int age ;
        private int level ;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    class Principal {
        private String name ;
        private int age ;
        private int level ;
    }
}
