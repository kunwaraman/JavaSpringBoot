package com.SpringbootDev.demo.rest;

import com.SpringbootDev.demo.enity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> theStudents;
    // define @PostConstruct to load the student data... only once!
    @PostConstruct
    public void loadData(){
        theStudents = new ArrayList<>();  // pe student list hata denge kyuki hamne already upar declare kar diya hai
        theStudents.add(new Student("poornima","patel"));
        theStudents.add(new Student("Mario","Rossi"));
        theStudents.add(new Student("Mary","Smith"));

    }
    // now i did like to actually load that student list

    // define endpoint for "/students" - return a list of students

    @GetMapping("/students")
    public List<Student> getSudents(){

//        List<Student> theStudents = new ArrayList<>();
////        theStudents.add(new Student("poornima","patel"));
////        theStudents.add(new Student("Mario","Rossi"));
////        theStudents.add(new Student("Mary","Smith"));

        return theStudents;
    }

    // spring boot path variables
    // define endpoint or"/student/{studentId}"- return student at index
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        //   just index into the list... keep it simple for now

        //check the student against the list size

        if((studentId>= theStudents.size()) || (studentId<0)){
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }
        return theStudents.get(studentId);
    }

    // Add an exception handler using @ExceptionHandler



}

















// rem how spring rest will actually take your actual pojo objects and convert
// convert those pojo objects to json and pass it back
