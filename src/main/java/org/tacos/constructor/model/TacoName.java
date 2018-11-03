package org.tacos.constructor.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TacoName {
  @NotNull
  @Size(
      min = 5,
      message = "TacoName must be at least 5 characters long"
  )
  private final String value;

  public TacoName(String value) {
    this.value = value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    TacoName tacoName = (TacoName) o;
    return Objects.equals(value, tacoName.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  @Override
  public String toString() {
    return value;
  }
}
