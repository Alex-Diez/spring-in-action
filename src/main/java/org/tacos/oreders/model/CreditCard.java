package org.tacos.oreders.model;

public class CreditCard {
  private String number;
  private String cardExpirationDate;
  private String cardValidationValue;

  public CreditCard(String number, String cardExpirationDate, String cardValidationValue) {
    this.number = number;
    this.cardExpirationDate = cardExpirationDate;
    this.cardValidationValue = cardValidationValue;
  }

  public String number() {
    return number;
  }

  public String expirationDate() {
    return cardExpirationDate;
  }

  public String validationValue() {
    return cardValidationValue;
  }

  public CreditCard withNumber(String number) {
    return new CreditCard(number, cardExpirationDate, cardValidationValue);
  }

  public CreditCard withExpiration(String expiration) {
    return new CreditCard(number, expiration, cardValidationValue);
  }

  public CreditCard withCardValidationValue(String cardValidationValue) {
    return new CreditCard(number, cardExpirationDate, cardValidationValue);
  }
}
