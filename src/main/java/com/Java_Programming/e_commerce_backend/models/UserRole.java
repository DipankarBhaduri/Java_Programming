package com.Java_Programming.e_commerce_backend.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "user_roles")
public class UserRole {

    @Id
    private String id;
    private String name;
    private String description;
    private List<String> permissions;
}