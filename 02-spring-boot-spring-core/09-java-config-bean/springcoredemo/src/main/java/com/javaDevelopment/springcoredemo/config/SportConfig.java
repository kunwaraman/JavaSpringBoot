package com.javaDevelopment.springcoredemo.config;

import com.javaDevelopment.springcoredemo.Coach;
import com.javaDevelopment.springcoredemo.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
    @Bean("aquatic")
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
