package com.Java_Programming.project.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "user")
public class ApplicationUser extends RootEntity {
    private String name;
    private String email;
    private List<String> contactNumber;
    private String password;
    private Date sqlDate = new Date() ;
    private String accountStatus = "active";
    private boolean isEmailVerified;
    private boolean isPhoneVerified;
}
