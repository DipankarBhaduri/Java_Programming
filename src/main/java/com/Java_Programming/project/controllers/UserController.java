package com.Java_Programming.project.controllers;

import com.Java_Programming.project.models.ApplicationUser;
import com.Java_Programming.project.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/user")
@CrossOrigin(origins = "http://127.0.0.1:5500")
@Component
public class UserController {

    @Autowired
    private UserServices userServices ;

    @PostMapping("/signup")
    public ResponseEntity<String> addNewApplicationUser(@RequestBody ApplicationUser applicationUser) {
        userServices.saveEntity(applicationUser);
        return new ResponseEntity<>(applicationUser.getName()+" Saved Successfully" , HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> applicationUserLogin(@RequestBody ApplicationUser applicationUser) {
        return userServices.loginUser(applicationUser);
    }

    @PostMapping("/test")
    public ResponseEntity<String> applicationUserTest() {
        return userServices.applicationUserTest();
    }
}