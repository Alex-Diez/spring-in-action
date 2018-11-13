package org.tacos.orders

import org.tacos.common.ports.Transformer
import org.tacos.oreders.OrderDto
import org.tacos.oreders.adapters.OrderDtoTransformerFactory
import org.tacos.oreders.model.Address
import org.tacos.oreders.model.CreditCard
import org.tacos.oreders.model.Order
import org.tacos.oreders.ports.OrderTransformerFactory
import spock.lang.Specification

class OrderDtoTransformerTest extends Specification {
  def 'should transform order to transfer object'() {
    given: 'order and transformer em'
    Order order = new Order('recipient name', address(), creditCard());
    OrderTransformerFactory<OrderDto> factory = new OrderDtoTransformerFactory()

    when: 'order transformed with the em'
    Transformer<OrderDto> transformer = order.transformWith(factory);

    then: 'transformer create order transfer object'
    OrderDto orderDto = transformer.transform()
    orderDto != null
    orderDto.recipientName == 'recipient name'
    orderDto.street == 'address street'
    orderDto.city == 'address city'
    orderDto.state == 'NY'
    orderDto.zip == '10001'
    orderDto.creditCardNumber == '5555555555554444'
    orderDto.creditCardExpirationDate == '10/21'
    orderDto.creditCardValidationValue == '123'
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
