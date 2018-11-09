package org.takos.orders

import org.tacos.oreders.model.Address
import org.tacos.oreders.model.CreditCard
import org.tacos.oreders.model.Order

trait OrderHelper {
  Map<String, String> addressDefaults = [
      'street': 'address street',
      'city'  : 'address city',
      'state' : 'NY',
      'zip'   : '10001'
  ]

  Address address(Map<String, String> params = addressDefaults) {
    return new Address(params['street'], params['city'], params['state'], params['zip']);
  }

  Map<String, String> creditCardDefaults = [
      'cardNumber'         : '5555555555554444',
      'cardExpirationDate' : '10/21',
      'cardValidationValue': '123'
  ]

  CreditCard creditCard(Map<String, String> params = creditCardDefaults) {
    return new CreditCard(params['cardNumber'], params['cardExpirationDate'], params['cardValidationValue']);
  }

  Map<String, ?> orderDefaults = [
      recipientName: "recipient name",
      address      : address(),
      creditCard   : creditCard()
  ]

  Order order(Map<String, ?> params = orderDefaults) {
    return new Order(params['recipientName'], params['address'], params['creditCard'])
  }
}
