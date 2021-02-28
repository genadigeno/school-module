package com.example.school.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.util.Date;

public class PupilAgeValidator implements ConstraintValidator<PupilAge, Date> {
    private final static Logger log = LoggerFactory.getLogger(PupilAgeValidator.class);

    @Override
    public void initialize(PupilAge constraintAnnotation) {
        log.info("Initialization of PupilAgeValidator ConstraintValidator<PupilAge, Date>");
    }

    @Override
    public boolean isValid(Date date, ConstraintValidatorContext constraintValidatorContext) {
        Date now = new Date();
        if (date == null) { return false; }
        log.info("Now:  " + now);
        log.info("Date: " + date);
        return !date.after(DateUtil.localDateToDate(LocalDate.now().minusYears(5))) &&
               !date.before(DateUtil.localDateToDate(LocalDate.now().minusYears(18)));
    }
}
