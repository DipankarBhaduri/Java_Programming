package com.Java_Programming.project1.services;

import com.Java_Programming.project1.models.ApplicationUser;
import com.Java_Programming.project1.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class UserServices {

    @Autowired
    private UserRepository yourEntityRepository ;

    public void saveEntity(ApplicationUser entity) {
        yourEntityRepository.save(entity);
    }

    public List<ApplicationUser> findEntity() {
        return yourEntityRepository.findAll();
    }
}