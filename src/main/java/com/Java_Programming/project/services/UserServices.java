package com.Java_Programming.project.services;

import com.Java_Programming.project.models.ApplicationUser;
import com.Java_Programming.project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class UserServices {

    @Autowired
    private UserRepository userRepository ;

    public void saveEntity(ApplicationUser entity) {
        userRepository.save(entity);
    }

    public void saveEntityInBulk(List<ApplicationUser> applicationUsers) {
        userRepository.saveAll(applicationUsers);
    }

    public List<ApplicationUser> findEntity() {
        return userRepository.findAll();
    }

    public void deleteEntity(List<String> applicationUserList) {
        userRepository.deleteAllById(applicationUserList);
    }
}