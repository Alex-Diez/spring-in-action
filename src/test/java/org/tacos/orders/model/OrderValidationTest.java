package org.tacos.orders.model;

import org.junit.jupiter.api.Test;
import org.tacos.ValidationTests;
import org.tacos.oreders.model.Address;
import org.tacos.oreders.model.CreditCard;
import org.tacos.oreders.model.Order;

import static org.assertj.core.api.Assertions.assertThat;

class OrderValidationTest extends ValidationTests {
  private static final Address validAddress = new Address("address street", "address city", "NY", "10001");
  private static final Address addressWithBlankStreet = validAddress.withStreet("");
  private static final Address addressWithBlankCity = validAddress.withCity("");
  private static final Address addressWithBlankState = validAddress.withState("");
  private static final Address addressWithBlankZip = validAddress.withZip("");
  private static final CreditCard validCreditCard = new CreditCard("5555555555554444", "10/21", "123");

  @Test
  void orderShouldBeValid() throws Exception {
    Order order = new Order("recipient name", validAddress, validCreditCard);

    assertThat(validationMessages(order)).isEmpty();
  }

  @Test
  void orderIsInvalid_whenUsernameIsBlank() throws Exception {
    Order order = new Order("", validAddress, validCreditCard);

    assertThat(validationMessages(order)).containsOnly("Recipient name is required");
  }

  @Test
  void orderIsInvalid_whenStreetIsBlank() throws Exception {
    Order order = new Order(
        "recipient name",
        addressWithBlankStreet,
        validCreditCard
    );

    assertThat(validationMessages(order)).containsOnly("Street is required");
  }

  @Test
  void orderIsInvalid_whenCityIsBlank() throws Exception {
    Order order = new Order(
        "recipient name",
        addressWithBlankCity,
        validCreditCard
    );

    assertThat(validationMessages(order)).containsOnly("City is required");
  }

  @Test
  void orderIsInvalid_whenStateIsBlank() throws Exception {
    Order order = new Order(
        "recipient name",
        addressWithBlankState,
        validCreditCard
    );

    assertThat(validationMessages(order)).containsOnly("State is required");
  }

  @Test
  void orderIsInvalid_whenZipCodeIsBlank() throws Exception {
    Order order = new Order(
        "recipient name",
        addressWithBlankZip,
        validCreditCard
    );

    assertThat(validationMessages(order)).containsOnly("Zip code is required");
  }

  @Test
  void orderIsInvalid_whenCreditCardNumberIsInvalid() throws Exception {
    Order order = new Order(
        "recipient name",
        validAddress,
        validCreditCard.withNumber("5555555555554443")
    );

    assertThat(validationMessages(order)).containsOnly("Not a valid credit card number");
  }

  @Test
  void orderIsInvalid_whenCreditCardExpirationIsInvalidDate() throws Exception {
    Order order = new Order(
        "recipient name",
        validAddress,
        validCreditCard.withExpiration("13/21")
    );

    assertThat(validationMessages(order)).containsOnly("Must be formatted MM/YY");
  }

  @Test
  void orderIsInvalid_whenCreditCardVerificationValueIsInvalidThreeDigitValue() throws Exception {
    Order order = new Order(
        "recipient name",
        validAddress,
        validCreditCard.withCardValidationValue("1234")
    );

    assertThat(validationMessages(order)).containsOnly("Invalid CVV");
  }
}
