package org.tako.orders

import org.tacos.oreders.model.Address
import org.tacos.oreders.model.CreditCard
import org.tacos.oreders.model.Order

trait OrderHelper {
  Address defaultAddress = address()
  CreditCard defaultCreditCard = creditCard()
  def defaults = [
      recipientName: "recipient name",
      address      : address(),
      creditCard   : creditCard()
  ]

  Order order(
      Map params = defaults) {
    return new Order(params['recipientName'], params['address'], params['creditCard'])
  }

  Address address(
      String street = "address street",
      String city = "address city",
      String state = "NY",
      String zip = "10001") {
    return new Address(street, city, state, zip);
  }

  CreditCard creditCard(
      String cardNumber = "5555555555554444",
      String cardExpirationDate = "10/21",
      String cardValidationValue = "123") {
    return new CreditCard(cardNumber, cardExpirationDate, cardValidationValue);
  }
}
