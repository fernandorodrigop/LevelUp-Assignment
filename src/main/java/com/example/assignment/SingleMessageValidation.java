package com.example.assignment;

import jakarta.validation.Constraint;
import jakarta.validation.ReportAsSingleViolation;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {})
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@ReportAsSingleViolation
@NotNull
@NotBlank
public @interface SingleMessageValidation {
    public abstract String message() default "{Value required}";

    public abstract Class<?>[] groups() default {};

    public abstract Class<?>[] payload() default {};
}
