package com.javaSpring.cruddemo.dao;

import com.javaSpring.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String theLastName);

    void update(Student theStudent);

    void delete(Integer id);

    // delete all elements from the database
    // i have this method that return int so we know how many people we delete it from the database

    int deleteAll();

}
