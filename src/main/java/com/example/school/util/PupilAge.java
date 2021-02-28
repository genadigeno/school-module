package com.example.school.util;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PupilAgeValidator.class)
public @interface PupilAge {
    String message() default "Pupil age must be between 6 and 18";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
