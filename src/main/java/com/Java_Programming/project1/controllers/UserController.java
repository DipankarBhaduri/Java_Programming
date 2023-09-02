package com.Java_Programming.project1.controllers;

import com.Java_Programming.project1.models.ApplicationUser;
import com.Java_Programming.project1.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import java.time.Duration;
import java.time.Instant;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
@Component
public class UserController {

    @Autowired
    private UserServices userServices ;


    @GetMapping("/add")
    public ResponseEntity<String> addNewApplicationUser(@RequestBody ApplicationUser applicationUser) {
        applicationUser.setSqlDate(new Date());
        userServices.saveEntity(applicationUser);
        return new ResponseEntity<>(applicationUser.getName()+" Saved Successfully" , HttpStatus.CREATED) ;
    }

    @GetMapping("/getDays")
    public ResponseEntity<List<Integer>> addNewApplicationUser() {
        List<ApplicationUser> applicationUsers = userServices.findEntity();
        List<Integer> integers = new ArrayList<>();
        for (ApplicationUser applicationUser : applicationUsers) {
            integers.add(calculateDateDifferenceInHours(applicationUser.getSqlDate()));
        }
        return new ResponseEntity<>(integers, HttpStatus.CREATED) ;
    }

    /**
     * Calculates the difference in days between the given date and the current date and time.
     *
     * @param lastSignInDate The date for which to calculate the difference.
     * @return The difference in days as an integer. Returns 0 in case of an error or invalid date format.
     */
    public static int calculateDateDifferenceInDays(Date lastSignInDate) {
        String dateString = lastSignInDate.toString();
        try {
            // Convert Date to instant
            Instant oldInstant = lastSignInDate.toInstant();

            // Get the current instant
            Instant currentInstant = Instant.now();

            // Calculate the difference in days
            long differenceInDays = Duration.between(oldInstant, currentInstant).toDays();

            return (int) differenceInDays;

        } catch (DateTimeParseException e) {
            System.err.println("Invalid date format: " + dateString);
        }
        return 0;
    }


    /**
     * Calculates the difference in hours between the given date and the current time.
     *
     * @param lastSignInDate The date for which to calculate the difference.
     * @return The difference in hours as an integer.
     */
    public static int calculateDateDifferenceInHours(Date lastSignInDate) {
        String dateString = lastSignInDate.toString();
        try {
            // Convert Date to Instant
            Instant oldInstant = lastSignInDate.toInstant();

            // Get the current Instant
            Instant currentInstant = Instant.now();

            // Calculate the difference in hours
            long differenceInHours = Duration.between(oldInstant, currentInstant).toHours();

            return (int) differenceInHours;

        } catch (DateTimeParseException e) {
            System.err.println("Invalid date format: " + dateString);
        }
        return 0;
    }
}