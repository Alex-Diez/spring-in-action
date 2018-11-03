package org.tacos.oreders.model;

import java.util.Objects;

import javax.validation.constraints.NotBlank;

public class Address {
  @NotBlank(message = "Street is required")
  private final String street;
  @NotBlank(message = "City is required")
  private final String city;
  @NotBlank(message = "State is required")
  private final String state;
  @NotBlank(message = "Zip code is required")
  private final String zip;

  public Address(String street, String city, String state, String zip) {
    this.street = street;
    this.city = city;
    this.state = state;
    this.zip = zip;
  }

  public Address withStreet(String street) {
    return new Address(street, city, state, zip);
  }

  public Address withCity(String city) {
    return new Address(street, city, state, zip);
  }

  public Address withState(String state) {
    return new Address(street, city, state, zip);
  }

  public Address withZip(String zip) {
    return new Address(street, city, state, zip);
  }

  public String street() {
    return street;
  }

  public String city() {
    return city;
  }

  public String state() {
    return state;
  }

  public String zip() {
    return zip;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Address address = (Address) o;
    return Objects.equals(street, address.street) &&
        Objects.equals(city, address.city) &&
        Objects.equals(state, address.state) &&
        Objects.equals(zip, address.zip);
  }

  @Override
  public int hashCode() {
    return Objects.hash(street, city, state, zip);
  }

  @Override
  public String toString() {
    return "Address{" +
        "street='" + street + '\'' +
        ", city='" + city + '\'' +
        ", state='" + state + '\'' +
        ", zip='" + zip + '\'' +
        '}';
  }
}
