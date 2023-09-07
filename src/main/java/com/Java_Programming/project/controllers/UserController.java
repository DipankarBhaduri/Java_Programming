package com.Java_Programming.project.controllers;

import com.Java_Programming.project.models.ApplicationUser;
import com.Java_Programming.project.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/rest/user")
@Component
public class UserController {

    @Autowired
    private UserServices userServices ;

    @PostMapping("/add")
    public ResponseEntity<String> addNewApplicationUser(@RequestBody ApplicationUser applicationUser) {
        applicationUser.setSqlDate(new Date());
        userServices.saveEntity(applicationUser);
        return new ResponseEntity<>(applicationUser.getName()+" Saved Successfully" , HttpStatus.CREATED);
    }

    @PostMapping("/bulk/add")
    public ResponseEntity<String> addBulkNewApplicationUser(@RequestBody List<ApplicationUser> applicationUserList) {
        applicationUserList.forEach(applicationUser -> {
            applicationUser.setSqlDate(new Date());
        });
        userServices.saveEntityInBulk(applicationUserList);
        return new ResponseEntity<>("Bulk Saved Successfully" , HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/duplicate")
    public ResponseEntity<String> deleteDuplicateApplicationUser(){
        List<ApplicationUser> applicationUserList = userServices.findEntity();
        List<String> applicationUserIds = new ArrayList<>();
        List<String> applicationUserEmails = new ArrayList<>();

        applicationUserList.stream()
                .filter(applicationUser -> applicationUser.getAccountStatus() != null &&
                        applicationUser.getEmail() != null)
                .forEach(applicationUser -> {
                    if(!applicationUserEmails.contains(applicationUser.getEmail())){
                        applicationUserEmails.add(applicationUser.getEmail());
                    }else{
                        applicationUserIds.add(applicationUser.get_id());
                    }
                });

        userServices.deleteEntity(applicationUserIds);
        return new ResponseEntity<>(applicationUserIds.size()+" duplicateRecordDeleted", HttpStatus.OK);
    }
}