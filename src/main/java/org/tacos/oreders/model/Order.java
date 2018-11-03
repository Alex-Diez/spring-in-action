package org.tacos.oreders.model;

import org.hibernate.validator.constraints.CreditCardNumber;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class Order {
  @NotBlank(message = "Recipient name is required")
  private String name;
  @Valid
  private Address address;
//  @NotBlank(message = "Street is required")
//  private String street;
//  @NotBlank(message = "City is required")
//  private String city;
//  @NotBlank(message = "State is required")
//  private String state;
//  @NotBlank(message = "Zip code is required")
//  private String zip;
  @CreditCardNumber(message = "Not a valid credit card number")
  private String ccNumber;
  @Pattern(
      regexp = "^(0[1-9]|1[0-2])([/])([1-9][0-9])$",
      message = "Must be formatted MM/YY"
  )
  private String ccExpiration;
  @Digits(integer = 3, fraction = 0, message = "Invalid CVV")
  private String ccCVV;

  public Order() {
  }

  public Order(String name, String street, String city,  String state, String zip,
      @CreditCardNumber(message = "Not a valid credit card number") String ccNumber,
      @Pattern(
          regexp = "^(0[1-9]|1[0-2])([/])([1-9][0-9])$",
          message = "Must be formatted MM/YY"
      ) String ccExpiration,
      @Digits(integer = 3, fraction = 0, message = "Invalid CVV") String ccCVV) {
    this(name, new Address(street, city, state, zip), ccNumber, ccExpiration, ccCVV);
  }

  public Order(String name, Address address,
               @CreditCardNumber(message = "Not a valid credit card number") String ccNumber,
               @Pattern(
                   regexp = "^(0[1-9]|1[0-2])([/])([1-9][0-9])$",
                   message = "Must be formatted MM/YY"
               ) String ccExpiration,
               @Digits(integer = 3, fraction = 0, message = "Invalid CVV") String ccCVV) {
    this.name = name;
    this.address = address;
    this.ccNumber = ccNumber;
    this.ccExpiration = ccExpiration;
    this.ccCVV = ccCVV;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getStreet() {
    return address.street();
  }

  public void setStreet(String street) {
    address = address.withStreet(street);
  }

  public String getCity() {
    return address.city();
  }

  public void setCity(String city) {
    address = address.withCity(city);
  }

  public String getState() {
    return address.state();
  }

  public void setState(String state) {
    address = address.withState(state);
  }

  public String getZip() {
    return address.zip();
  }

  public void setZip(String zip) {
    address = address.withZip(zip);
  }

  public String getCcNumber() {
    return ccNumber;
  }

  public void setCcNumber(String ccNumber) {
    this.ccNumber = ccNumber;
  }

  public String getCcExpiration() {
    return ccExpiration;
  }

  public void setCcExpiration(String ccExpiration) {
    this.ccExpiration = ccExpiration;
  }

  public String getCcCVV() {
    return ccCVV;
  }

  public void setCcCVV(String ccCVV) {
    this.ccCVV = ccCVV;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Order order = (Order) o;
    return Objects.equals(getName(), order.getName()) &&
        Objects.equals(address, order.address) &&
        Objects.equals(getCcNumber(), order.getCcNumber()) &&
        Objects.equals(getCcExpiration(), order.getCcExpiration()) &&
        Objects.equals(getCcCVV(), order.getCcCVV());
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        getName(),
        address,
        getCcNumber(),
        getCcExpiration(),
        getCcCVV()
    );
  }

  @Override
  public String toString() {
    return "Order{" +
        "name='" + name + '\'' +
        ", address='" + address + '\'' +
        ", ccNumber='" + ccNumber + '\'' +
        ", ccExpiration='" + ccExpiration + '\'' +
        ", ccCVV='" + ccCVV + '\'' +
        '}';
  }
}
