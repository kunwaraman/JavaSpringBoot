package com.springboot.mvcform.validation.mvc;

import com.springboot.mvcform.validation.mvc.validationC.CourseCode;
import jakarta.validation.constraints.*;

public class Customer {
    private String firstName;
   @Pattern(regexp="^[a-zA-Z0-9]{5}",message = "only 5 chars/digit")
    private String postalCode;
    @CourseCode
   private String courseCode;

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @NotNull(message="is required")
    @Size(min=1,message = "is required")
    private  String lastName = "";

    @NotNull(message = "is required")
    @Min(value=0,message="must be greater than or equal to zero")
    @Max(value=10,message = "must be less than or equal to 10")
    private int freePasses;

    public int getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(int freePasses) {
        this.freePasses = freePasses;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
