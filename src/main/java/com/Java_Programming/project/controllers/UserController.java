package com.Java_Programming.project.controllers;

import com.Java_Programming.project.models.ApplicationUser;
import com.Java_Programming.project.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/rest/user")
@Component
public class UserController {

    @Autowired
    private UserServices userServices ;

    @GetMapping("/add")
    public ResponseEntity<String> addNewApplicationUser(@RequestBody ApplicationUser applicationUser) {
        applicationUser.setSqlDate(new Date());
        userServices.saveEntity(applicationUser);
        return new ResponseEntity<>(applicationUser.getName()+" Saved Successfully" , HttpStatus.CREATED);
    }
}