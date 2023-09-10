package com.Java_Programming.project.repositories;

import com.Java_Programming.project.models.ApplicationUser;
import org.bson.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.SortedSet;

@Repository
public interface UserRepository extends MongoRepository<ApplicationUser, String> {

}