package com.example.school.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

public class CommonUtil {
    private final static Logger log = LoggerFactory.getLogger(CommonUtil.class);

    public static List<String> collectErrors(List<FieldError> errorList){
        List<String> errors = new ArrayList<String>();
        for (FieldError fieldError : errorList) {
            log.warn(fieldError.getField()+" - "+fieldError.getDefaultMessage());
            errors.add(fieldError.getDefaultMessage());
        }
        return errors;
    }

    public static List<String> collectErrors(String error) {
        List<String> errors = new ArrayList<String>();
        log.warn(error);
        errors.add(error);
        return errors;
    }
}
