package com.javaDevelopment.springcoredemo.rest;

import com.javaDevelopment.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    // define a privet field for the dependency

    private Coach myCoach;

    // define a constructor for dependency injection
    @Autowired  // tells spring to inject a dependency
    public DemoController (Coach theCoach){
        myCoach = theCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

    //@SpringBootApplication(
    //		scanBasePackages = {"com.javaDevelopent.springcoredemo",
    //		"com.aman.util"}
    //)
    @SpringBootApplication
    public static class SpringcoredemoApplication {

        public static void main(String[] args) {
            SpringApplication.run(SpringcoredemoApplication.class, args);
        }

    }
}
