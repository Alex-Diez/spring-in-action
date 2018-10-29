package org.ua.spring.tacos.tacoscloud;

import org.hibernate.validator.constraints.CreditCardNumber;
import org.immutables.value.Value;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import static org.immutables.value.Value.Style.ValidationMethod;

@Value.Modifiable
@Value.Style(beanFriendlyModifiables = true, create = "new", validationMethod = ValidationMethod.VALIDATION_API)
public abstract class Order {
  @Value.Parameter
  @NotBlank(message = "Name is required")
  public abstract String getName();

  @Value.Parameter
  @NotBlank(message = "Street is required")
  public abstract String getStreet();

  @Value.Parameter
  @NotBlank(message = "City is required")
  public abstract String getCity();

  @Value.Parameter
  @NotBlank(message = "State is required")
  public abstract String getState();

  @Value.Parameter
  @NotBlank(message = "Zip code is required")
  public abstract String getZip();

  @Value.Parameter
  @CreditCardNumber(message = "Not a valid credit card number")
  public abstract String getCcNumber();

  @Value.Parameter
  @Pattern(
      regexp = "^(0[1-9]|1[0-2])([/])([1-9][0-9])$",
      message = "Must be formatted MM/YY"
  )
  public abstract String getCcExpiration();

  @Value.Parameter
  @Digits(integer = 3, fraction = 0, message = "Invalid CVV")
  public abstract String getCcCVV();
}
