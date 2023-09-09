package com.Java_Programming.project.services;

import com.Java_Programming.project.models.ApplicationUser;
import com.Java_Programming.project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
@Component
public class UserServices {

    @Autowired
    private UserRepository userRepository ;

    public void saveEntity(ApplicationUser entity) {
        entity.setSqlDate(new Date());
        userRepository.save(entity);
    }

    public ResponseEntity<String> loginUser(ApplicationUser entity) {
        List<ApplicationUser> users = userRepository.findAll();
        List<ApplicationUser> applicationUsers = users.stream()
                .filter( applicationUser -> applicationUser
                        .getEmail()
                        .equals(entity.getEmail()) && applicationUser
                        .getPassword()
                        .equals(entity.getPassword()))
                .toList();

        if (!applicationUsers.isEmpty()) return new ResponseEntity<>( "Success",HttpStatus.OK) ;
        return new ResponseEntity<>( "Failed",HttpStatus.NOT_FOUND);
    }
}