package org.tacos.oreders.model;

import org.tacos.common.ports.Transformer;
import org.tacos.oreders.ports.OrderTransformerFactory;

import java.util.Objects;

public class Order {
  private String recipientName;
  private Address address;
  private CreditCard creditCard;

  public Order() {
    this("", new Address("", "", "", ""), new CreditCard("", "", ""));
  }

  public Order(String recipientName, Address address, CreditCard creditCard) {
    this.recipientName = recipientName;
    this.address = address;
    this.creditCard = creditCard;
  }

  public String recipientName() {
    return recipientName;
  }

  public String street() {
    return address != null ? address.street() : "";
  }

  public String city() {
    return address != null ? address.city() : "";
  }

  public String state() {
    return address != null ? address.state() : "";
  }

  public String zip() {
    return address != null ? address.zip() : "";
  }

  public String creditCardNumber() {
    return creditCard != null ? creditCard.number() : "";
  }

  public String creditCardExpirationDate() {
    return creditCard != null ? creditCard.expirationDate() : "";
  }

  public String creditCardValidationValue() {
    return creditCard != null ? creditCard.validationValue() : "";
  }

  public <T> Transformer<T> transformWith(OrderTransformerFactory<T> factory) {
    return factory.createTransformer(
        recipientName,
        address.street(),
        address.city(),
        address.state(),
        address.zip(),
        creditCard.number(),
        creditCard.expirationDate(),
        creditCard.validationValue()
    );
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Order order = (Order) o;
    return Objects.equals(recipientName(), order.recipientName()) &&
        Objects.equals(address, order.address) &&
        Objects.equals(creditCardNumber(), order.creditCardNumber()) &&
        Objects.equals(creditCardExpirationDate(), order.creditCardExpirationDate()) &&
        Objects.equals(creditCardValidationValue(), order.creditCardValidationValue());
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        recipientName(),
        address,
        creditCardNumber(),
        creditCardExpirationDate(),
        creditCardValidationValue()
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
