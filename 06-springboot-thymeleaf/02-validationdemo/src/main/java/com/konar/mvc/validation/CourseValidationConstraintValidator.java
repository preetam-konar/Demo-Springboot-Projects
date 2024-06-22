package com.konar.mvc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseValidationConstraintValidator implements ConstraintValidator<CourseValidation, String> {

    private String coursePrefix;

    @Override
    public void initialize(CourseValidation courseValidation) {
        coursePrefix = courseValidation.value();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(s!=null) {
            return s.startsWith(coursePrefix);
        }
        return true;
    }
}
