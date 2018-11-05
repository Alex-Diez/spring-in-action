package org.tacos.oreders.model;

import org.hibernate.validator.constraints.CreditCardNumber;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;

public class CreditCard {
  @CreditCardNumber(message = "Not a valid credit card number")
  private String number;
  @Pattern(
      regexp = "^(0[1-9]|1[0-2])([/])([1-9][0-9])$",
      message = "Must be formatted MM/YY"
  )
  private String expirationDate;
  @Digits(integer = 3, fraction = 0, message = "Invalid CVV")
  private String cardValidationValue;

  public CreditCard(
      @CreditCardNumber(message = "Not a valid credit card number") String number,
      @Pattern(
          regexp = "^(0[1-9]|1[0-2])([/])([1-9][0-9])$",
          message = "Must be formatted MM/YY"
      ) String expirationDate,
      @Digits(integer = 3, fraction = 0, message = "Invalid CVV") String cardValidationValue) {
    this.number = number;
    this.expirationDate = expirationDate;
    this.cardValidationValue = cardValidationValue;
  }

  public String number() {
    return number;
  }

  public String expirationDate() {
    return expirationDate;
  }

  public String cardValidationValue() {
    return cardValidationValue;
  }

  public CreditCard withNumber(String number) {
    return new CreditCard(number, expirationDate, cardValidationValue);
  }

  public CreditCard withExpiration(String expiration) {
    return new CreditCard(number, expiration, cardValidationValue);
  }

  public CreditCard withCardValidationValue(String cardValidationValue) {
    return new CreditCard(number, expirationDate, cardValidationValue);
  }
}
