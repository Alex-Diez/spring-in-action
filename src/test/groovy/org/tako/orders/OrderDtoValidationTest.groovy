package org.tako.orders

import org.tacos.oreders.OrderDto
import org.tacos.oreders.adapters.OrderDtoTransformerFactory
import org.tacos.oreders.model.Order
import org.tako.ValidationSpec

class OrderDtoValidationTest extends ValidationSpec implements OrderHelper {

  def 'order should be valid'() {
    given: 'valid order dto'
    Order order = order();
    OrderDto orderDto = order.transformWith(new OrderDtoTransformerFactory()).transform()

    when: 'valid order transfer object validated'
    def constraintViolations = validate(orderDto)

    then: 'validation set is empty'
    constraintViolations.isEmpty()
  }

  def 'order with blank recipient name is invalid'() {
    given: 'order dto with blank recipient name'
    Order order = order(defaults << [recipientName: '']);
    OrderDto orderDto = order.transformWith(new OrderDtoTransformerFactory()).transform()

    when: 'order transfer object validated'
    def constraintViolation = validate(orderDto)

    then: 'validation set contains single message about empty name'
    constraintViolation.size() == 1
    constraintViolation.contains("Recipient name is required")
  }

  def 'order with blank recipient street is invalid'() {
    given: 'order dto with blank recipient street'
    Order order = order(defaults << [address: address("")]);
    OrderDto orderDto = order.transformWith(new OrderDtoTransformerFactory()).transform()

    when: 'order transfer object validated'
    def constraintViolation = validate(orderDto)

    then: 'validation set contains single message about empty street'
    constraintViolation.size() == 1
    constraintViolation.contains("Street is required")
  }
}
