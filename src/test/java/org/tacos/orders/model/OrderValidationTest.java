package org.tacos.orders.model;

import org.junit.jupiter.api.Test;
import org.tacos.ValidationTests;
import org.tacos.oreders.model.Address;
import org.tacos.oreders.model.Order;

import static org.assertj.core.api.Assertions.assertThat;

class OrderValidationTest extends ValidationTests {
  private static final Address completeAddress = new Address("address street", "address city", "NY", "10001");
  private static final Address addressWithBlankStreet = completeAddress.withStreet("");
  private static final Address addressWithBlankCity = completeAddress.withCity("");
  private static final Address addressWithBlankState = completeAddress.withState("");
  private static final Address addressWithBlankZip = completeAddress.withZip("");

  @Test
  void orderShouldBeValid() throws Exception {
    Order order = new Order(
        "recipient name",
        completeAddress,
        "5555555555554444",
        "10/21",
        "123"
    );

    assertThat(validationMessages(order)).isEmpty();
  }

  @Test
  void orderIsInvalid_whenUsernameIsBlank() throws Exception {
    Order order = new Order(
        "",
        completeAddress,
        "5555555555554444",
        "10/21",
        "123"
    );

    assertThat(validationMessages(order)).containsOnly("Recipient name is required");
  }

  @Test
  void orderIsInvalid_whenStreetIsBlank() throws Exception {
    Order order = new Order(
        "recipient name",
        addressWithBlankStreet,
        "5555555555554444",
        "10/21",
        "123"
    );

    assertThat(validationMessages(order)).containsOnly("Street is required");
  }

  @Test
  void orderIsInvalid_whenCityIsBlank() throws Exception {
    Order order = new Order(
        "recipient name",
        addressWithBlankCity,
        "5555555555554444",
        "10/21",
        "123"
    );

    assertThat(validationMessages(order)).containsOnly("City is required");
  }

  @Test
  void orderIsInvalid_whenStateIsBlank() throws Exception {
    Order order = new Order(
        "recipient name",
        addressWithBlankState,
        "5555555555554444",
        "10/21",
        "123"
    );

    assertThat(validationMessages(order)).containsOnly("State is required");
  }

  @Test
  void orderIsInvalid_whenZipCodeIsBlank() throws Exception {
    Order order = new Order(
        "recipient name",
        addressWithBlankZip,
        "5555555555554444",
        "10/21",
        "123"
    );

    assertThat(validationMessages(order)).containsOnly("Zip code is required");
  }
}
