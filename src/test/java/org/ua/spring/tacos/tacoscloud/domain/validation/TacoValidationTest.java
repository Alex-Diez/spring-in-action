package org.ua.spring.tacos.tacoscloud.domain.validation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.ua.spring.tacos.tacoscloud.domain.Ingredient;
import org.ua.spring.tacos.tacoscloud.domain.Taco;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import static org.assertj.core.api.Assertions.assertThat;

class TacoValidationTest {

  private static final String longEnoughTacoName = "long enough name";
  private static final String shortTacoName = "shrt";
  private static final List<String> nonemptyIngredients = List.of(Ingredient.Type.CHEESE.toString());

  private Validator validator;

  @BeforeEach
  void setUp() throws Exception {
    ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    validator = validatorFactory.getValidator();
  }

  private Set<String> validationMessages(Taco taco) {
    return validator.validate(taco)
        .stream()
        .map(ConstraintViolation::getMessage)
        .collect(Collectors.toSet());
  }

  @Test
  void takoShouldHaveNameLonger_thanFourChars() throws Exception {
    Taco taco = new Taco(longEnoughTacoName);
    taco.setIngredients(nonemptyIngredients);

    assertThat(validationMessages(taco)).isEmpty();
  }

  @Test
  void takoShouldBeInvalid_whenIngredientListIsEmpty() throws Exception {
    Taco taco = new Taco(longEnoughTacoName);
    taco.setIngredients(List.of());

    assertThat(validationMessages(taco)).containsOnly("You must choose at least 1 ingredient");
  }

  @Test
  void takoShouldBeInvalid_whenNameShorterThanFourChars() throws Exception {
    Taco taco = new Taco(shortTacoName);
    taco.setIngredients(nonemptyIngredients);

    assertThat(validationMessages(taco)).containsOnly("Name must be at least 5 characters long");
  }
}
