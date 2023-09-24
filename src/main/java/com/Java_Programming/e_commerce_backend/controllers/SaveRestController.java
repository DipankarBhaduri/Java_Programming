package com.Java_Programming.e_commerce_backend.controllers;

import com.Java_Programming.e_commerce_backend.services.SaveRestServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/rest")
@Component
public class SaveRestController {

    @Autowired
    private SaveRestServices saveRestServices;

    private static final Logger logger = LoggerFactory.getLogger(SaveRestController.class);

    @PostMapping("/save/{entityName}")
    public ResponseEntity<String> save (@PathVariable String entityName, @RequestBody Object object) {

        String message = "";
        try {
            message = saveRestServices.saveObject(entityName, object);
        } catch (Exception e) {
            logger.error("Error during save the entity {} "+ entityName);
        }
        return ResponseEntity.ok(message);
    }
}
