package org.ua.spring.tacos.tacoscloud.domain;

import org.immutables.value.Value;

@Value.Immutable
public abstract class Ingredient {

  public String key() {
    return getType().toString().toLowerCase();
  }

  public abstract String getId();

  public abstract String getName();

  public abstract Type getType();

  public enum Type {
    WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
  }
}
