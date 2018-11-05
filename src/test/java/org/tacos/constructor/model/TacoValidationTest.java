package org.tacos.constructor.model;

import org.junit.jupiter.api.Test;
import org.tacos.ValidationTests;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TacoValidationTest extends ValidationTests {

  private static final String longEnoughTacoName = "long enough name";
  private static final String shortTacoName = "shrt";
  private static final List<String> nonemptyIngredients = List.of(Ingredient.Type.CHEESE.toString());

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

    assertThat(validationMessages(taco)).containsOnly("Taco name must be at least 5 characters long");
  }
}
