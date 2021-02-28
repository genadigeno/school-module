package com.example.school.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Date;

public class MyDateValidator implements ConstraintValidator<PastDate, Date> {
    private final static Logger log = LoggerFactory.getLogger(MyDateValidator.class);

    @Override
    public void initialize(PastDate constraintAnnotation) {
        log.info("Initialization of MyDateValidator ConstraintValidator<PastDate, Date>");
    }

    @Override
    public boolean isValid(Date date, ConstraintValidatorContext constraintValidatorContext) {
        Date now = new Date();
        if (date == null) { return false; }
        log.info("Result of Validation: " + now.after(date));
        log.info("Now:  " + now);
        log.info("Date: " + date);
        return new Date().after(date);
    }
}
