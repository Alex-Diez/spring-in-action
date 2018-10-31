package org.ua.spring.tacos.tacoscloud.domain;

import org.immutables.value.Value;
import org.immutables.value.Value.Style.ValidationMethod;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Value.Modifiable
@Value.Style(
    beanFriendlyModifiables = true,
    create = "new",
    validationMethod = ValidationMethod.VALIDATION_API
)
public abstract class Taco {
  @Value.Parameter
  @NotNull
  @Size(
      min = 5,
      message = "Name must be at least 5 characters long"
  )
  public abstract String getName();

  @Value.Parameter
  @NotNull
  @Size(
      min = 1,
      message = "You must choose at least 1 ingredient"
  )
  public abstract List<String> getIngredients();
}
