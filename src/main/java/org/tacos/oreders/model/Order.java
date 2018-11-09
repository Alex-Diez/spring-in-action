package org.tacos.oreders.model;

import org.tacos.oreders.port.OrderTransformer;
import org.tacos.oreders.port.OrderTransformerFactory;

import java.util.Objects;

import javax.validation.Valid;

public class Order {
  private String recipientName;
  @Valid
  private Address address;
  @Valid
  private CreditCard creditCard;

  public Order() {
    this("", new Address("", "", "", ""), new CreditCard("", "", ""));
  }

  public Order(String recipientName, Address address, CreditCard creditCard) {
    this.recipientName = recipientName;
    this.address = address;
    this.creditCard = creditCard;
  }

  public String getRecipientName() {
    return recipientName;
  }

  public void setRecipientName(String recipientName) {
    this.recipientName = recipientName;
  }

  public String getStreet() {
    return address != null ? address.street() : "";
  }

  public void setStreet(String street) {
    address = address.withStreet(street);
  }

  public String getCity() {
    return address != null ? address.city() : "";
  }

  public void setCity(String city) {
    address = address.withCity(city);
  }

  public String getState() {
    return address != null ? address.state() : "";
  }

  public void setState(String state) {
    address = address.withState(state);
  }

  public String getZip() {
    return address != null ? address.zip() : "";
  }

  public void setZip(String zip) {
    address = address.withZip(zip);
  }

  public String getCreditCardNumber() {
    return creditCard != null ? creditCard.number() : "";
  }

  public void setCreditCardNumber(String creditCardNumber) {
    this.creditCard = creditCard.withNumber(creditCardNumber);
  }

  public String getCreditCardExpirationDate() {
    return creditCard != null ? creditCard.expirationDate() : "";
  }

  public void setCreditCardExpirationDate(String expirationDate) {
    this.creditCard = creditCard.withExpiration(expirationDate);
  }

  public String getCreditCardValidationValue() {
    return creditCard != null ? creditCard.cardValidationValue() : "";
  }

  public void setCreditCardValidationValue(String cardValidationValue) {
    this.creditCard = creditCard.withCardValidationValue(cardValidationValue);
  }

  public <T> OrderTransformer<T> transformWith(OrderTransformerFactory<T> factory) {
    return factory.createTransformer(
        recipientName,
        address.street(),
        address.city(),
        address.state(),
        address.zip(),
        creditCard.number(),
        creditCard.expirationDate(),
        creditCard.cardValidationValue()
    );
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Order order = (Order) o;
    return Objects.equals(getRecipientName(), order.getRecipientName()) &&
        Objects.equals(address, order.address) &&
        Objects.equals(getCreditCardNumber(), order.getCreditCardNumber()) &&
        Objects.equals(getCreditCardExpirationDate(), order.getCreditCardExpirationDate()) &&
        Objects.equals(getCreditCardValidationValue(), order.getCreditCardValidationValue());
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        getRecipientName(),
        address,
        getCreditCardNumber(),
        getCreditCardExpirationDate(),
        getCreditCardValidationValue()
    );
  }

  @Override
  public String toString() {
    return "Order{" +
        "recipientName='" + recipientName + '\'' +
        ", address='" + address + '\'' +
        ", credit card='" + creditCard + '\'' +
        '}';
  }
}
