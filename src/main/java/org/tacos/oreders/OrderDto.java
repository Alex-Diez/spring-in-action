package org.tacos.oreders;

import org.hibernate.validator.constraints.CreditCardNumber;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class OrderDto {
  @NotBlank(message = "Recipient name is required")
  private String recipientName;
  @NotBlank(message = "Street is required")
  private String street;
  @NotBlank(message = "City is required")
  private String city;
  @NotBlank(message = "State is required")
  private String state;
  @NotBlank(message = "Zip code is required")
  private String zip;
  @CreditCardNumber(message = "Not a valid credit card number")
  private String number;
  @Pattern(
      regexp = "^(0[1-9]|1[0-2])([/])([1-9][0-9])$",
      message = "Card expiration date must be formatted as MM/YY"
  )
  private String expirationDate;
  @Digits(integer = 3, fraction = 0, message = "Invalid Card Validation Value")
  private String cardValidationValue;

  public OrderDto() {
    this("", "", "", "", "", "", "", "");
  }

  public OrderDto(
      String recipientName,
      String street,
      String city,
      String state,
      String zip,
      String number,
      String expirationDate,
      String cardValidationValue) {
    this.recipientName = recipientName;
    this.street = street;
    this.city = city;
    this.state = state;
    this.zip = zip;
    this.number = number;
    this.expirationDate = expirationDate;
    this.cardValidationValue = cardValidationValue;
  }

  public String getRecipientName() {
    return recipientName;
  }

  public void setRecipientName(String recipientName) {
    this.recipientName = recipientName;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getZip() {
    return zip;
  }

  public void setZip(String zip) {
    this.zip = zip;
  }

  public String getCreditCardNumber() {
    return number;
  }

  public void setCreditCardNumber(String number) {
    this.number = number;
  }

  public String getCreditCardExpirationDate() {
    return expirationDate;
  }

  public void setCreditCardExpirationDate(String expirationDate) {
    this.expirationDate = expirationDate;
  }

  public String getCreditCardValidationValue() {
    return cardValidationValue;
  }

  public void setCreditCardValidationValue(String cardValidationValue) {
    this.cardValidationValue = cardValidationValue;
  }
}
