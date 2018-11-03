package org.tacos.orders.model;

import org.junit.jupiter.api.Test;
import org.tacos.oreders.model.Order;

import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import static org.assertj.core.api.Assertions.assertThat;

class OrderValidationTest {
  @Test
  void orderShouldBeValid() throws Exception {
    Order order = new Order(
        "person name",
        "address street",
        "address city",
        "NY",
        "10001",
        "5555555555554444",
        "10/21",
        "123"
    );

    final ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    final Validator validator = validatorFactory.getValidator();

    final Set<ConstraintViolation<Order>> constraintViolations = validator.validate(order);

    assertThat(constraintViolations.stream().map(ConstraintViolation::getMessage).collect(Collectors.toSet()))
        .isEmpty();
  }
}
