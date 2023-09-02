package com.Java_Programming.project1.repositories;

import com.Java_Programming.project1.models.ApplicationUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<ApplicationUser, String> {

}
