package org.tako.orders

import org.tacos.oreders.OrderDto
import org.tacos.oreders.adapters.OrderDtoTransformerFactory
import org.tacos.oreders.model.Address
import org.tacos.oreders.model.CreditCard
import org.tacos.oreders.model.Order
import spock.lang.Specification

import javax.validation.Validation

class OrderDtoValidationTest extends Specification {

  def 'order should be valid'() {
    given: 'order'
    Order order = new Order("recipient name", address(), creditCard());
    OrderDto orderDto = order.transformWith(new OrderDtoTransformerFactory()).transform()
    def factory = Validation.buildDefaultValidatorFactory()
    def validator = factory.validator

    when:
    def constraintViolations = validator.validate(orderDto)

    then:
    constraintViolations.isEmpty()
  }

  Address address(
      String street = "address street",
      String city = "address city",
      String state = "NY",
      String zip = "10001") {
    return new Address(street, city, state, zip);
  }

  CreditCard creditCard() {
    return new CreditCard("5555555555554444", "10/21", "123");
  }
}
