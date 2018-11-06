package org.tacos.constructor.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Taco {
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
  private final List<String> ingredients = new ArrayList<String>();

  public Taco() {
    this("");
  }

  public Taco(String name) {
    this.name = name;
  }

  public String getName() {
    return name != null ? name.toString() : "";
  }

  public List<String> getIngredients() {
    return new ArrayList<>(ingredients);
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setIngredients(Collection<String> ingredients) {
    this.ingredients.clear();
    this.ingredients.addAll(ingredients);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Taco taco = (Taco) o;
    return Objects.equals(getName(), taco.getName()) &&
        Objects.equals(getIngredients(), taco.getIngredients());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), getIngredients());
  }

  @Override
  public String toString() {
    return "Taco{" +
        "name='" + name + '\'' +
        ", ingredients=" + ingredients +
        '}';
  }
}
