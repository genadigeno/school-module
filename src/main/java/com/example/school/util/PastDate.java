package com.example.school.util;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MyDateValidator.class)
public @interface PastDate {
    String message() default "Date must bee past or present";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
