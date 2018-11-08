package org.tacos.oreders;

public class OrderDto {
  private String recipientName;
  private String street;
  private String city;
  private String state;
  private String zip;
  private String number;
  private String expirationDate;
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
