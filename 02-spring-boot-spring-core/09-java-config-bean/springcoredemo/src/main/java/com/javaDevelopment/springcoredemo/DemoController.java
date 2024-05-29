package com.javaDevelopment.springcoredemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    // define a privet field for the dependency

    private Coach myCoach;
    private Coach anotherCoach;
    @Autowired
    public DemoController(@Qualifier("aquatic")Coach theCoach){    // ish dono case main don constructor main hm ek hi chij mang rhe hai coach){
        System.out.println("In constructor: " + getClass().getSimpleName());
        myCoach = theCoach;

    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }


}
