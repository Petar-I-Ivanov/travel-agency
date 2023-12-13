package org.pufmi.holiday.service.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = ValidDoubleValueValidator.class)
@Documented
public @interface ValidDoubleValue {

  String message() default "Provided string isn't valid double value";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
