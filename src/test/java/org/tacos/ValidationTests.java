package org.tacos;

import org.junit.jupiter.api.BeforeEach;
import org.tacos.constructor.model.Taco;

import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public abstract class ValidationTests {

  private Validator validator;

  @BeforeEach
  void setUp() throws Exception {
    ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    validator = validatorFactory.getValidator();
  }


  protected Set<String> validationMessages(Object entityToValidate) {
    return validator.validate(entityToValidate)
        .stream()
        .map(ConstraintViolation::getMessage)
        .collect(Collectors.toSet());
  }
}
