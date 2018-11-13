package org.tacos.constructor.domain.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TacoDto {
  @NotNull
  @Size(
      min = 5,
      message = "Taco name must be at least 5 characters long"
  )
  private String name;
  @NotNull
  @Size(
      min = 1,
      message = "You must choose at least 1 ingredient"
  )
  private List<String> ingredients = new ArrayList<>();

  public TacoDto() {
    this("", new ArrayList<>());
  }

  public TacoDto(String name, List<String> ingredients) {
    this.name = name;
    this.ingredients.clear();
    this.ingredients.addAll(ingredients);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<String> getIngredients() {
    return ingredients;
  }

  public void setIngredients(List<String> ingredients) {
    this.ingredients.clear();
    this.ingredients.addAll(ingredients);
  }
}
