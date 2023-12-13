package org.pufmi.holiday.service.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Optional;

public class ValidDoubleValueValidator implements ConstraintValidator<ValidDoubleValue, String> {

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    return Optional.ofNullable(value)
        .map(
            val -> {
              try {
                Double.parseDouble(val);
                return true;
              } catch (NumberFormatException e) {
                return false;
              }
            })
        .orElse(true);
  }
}
