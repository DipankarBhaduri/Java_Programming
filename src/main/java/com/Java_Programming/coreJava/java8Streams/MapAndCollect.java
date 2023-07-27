package com.Java_Programming.coreJava.java8Streams;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapAndCollect {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("Dipankar" ,
                "Pritam" , "Suvodeep" , "Arijit" , "Souvik" ,
                "Surja" , "saheb")) ;

        List<User> userList = list.stream()
                .map(User::new)
                .collect(Collectors.toList());

        Map<String , User > stringUserMap =  userList.stream()
                .collect(Collectors.toMap(User::getName , user -> user)) ;

        for ( Map.Entry<String,User> entry : stringUserMap.entrySet()){
            System.out.println(entry.getKey()+" --> ");
        }
    }
}

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
class User {
    private String name ;
    private int age ;

    public User(String string) {
        this.name = string ;
    }
}