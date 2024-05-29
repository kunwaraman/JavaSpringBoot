package com.springboot.mvcform.validation.mvc.validationC;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.annotation.Annotation;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode,String> {


    private String coursePrefix;
    @Override
    public void initialize(CourseCode thCourseCode) {
        coursePrefix= thCourseCode.value();
    }

    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext theConstraintValidatorContext) {
        boolean result;
        if(theCode!=null) {
            result = theCode.startsWith(coursePrefix);
        }else {
            result=true;
        }

        return result;
    }
}





