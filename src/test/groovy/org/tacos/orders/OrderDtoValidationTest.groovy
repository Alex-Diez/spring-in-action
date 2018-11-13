package org.tacos.orders

import org.tacos.ValidationSpec
import org.tacos.oreders.OrderDto
import org.tacos.oreders.adapters.OrderDtoTransformerFactory
import org.tacos.oreders.ports.OrderTransformerFactory

class OrderDtoValidationTest extends ValidationSpec implements OrderHelper {
  private final OrderTransformerFactory<OrderDto> factory = new OrderDtoTransformerFactory()

  def dto(Map<String, ?> params = orderDefaults) {
    order(params).transformWith(factory).transform()
  }

  def 'order should be valid'() {
    given: 'valid order dto'
    OrderDto orderDto = dto()

    when: 'valid order transfer object validated'
    def constraintViolations = validate(orderDto)

    then: 'validation set is empty'
    constraintViolations.isEmpty()
  }

  def 'order with blank recipient name is invalid'() {
    given: 'order dto with blank recipient name'
    OrderDto orderDto = dto(orderDefaults << [recipientName: ''])

    when: 'order transfer object validated'
    def constraintViolation = validate(orderDto)

    then: 'validation set contains single message about empty name'
    constraintViolation.size() == 1
    constraintViolation.contains('Recipient name is required')
  }

  def 'order with blank recipient street is invalid'() {
    given: 'order dto with blank recipient street'
    OrderDto orderDto = dto(orderDefaults << [address: address(addressDefaults << [street: ''])])

    when: 'order transfer object validated'
    def constraintViolation = validate(orderDto)

    then: 'validation set contains single message about empty street'
    constraintViolation.size() == 1
    constraintViolation.contains('Street is required')
  }

  def 'order with blank recipient city is invalid'() {
    given: 'order dto with blank recipient city'
    OrderDto orderDto = dto(orderDefaults << [address: address(addressDefaults << [city: ''])])

    when: 'order dto validated'
    def constraintViolation = validate(orderDto)

    then: 'validation set contains single message about empty city'
    constraintViolation.size() == 1
    constraintViolation.contains('City is required')
  }

  def 'order with blank recipient state is invalid'() {
    given: 'order dto with blank recipient state'
    OrderDto orderDto = dto(orderDefaults << [address: address(addressDefaults << [state: ''])])

    when: 'order dto validated'
    def constraintViolation = validate(orderDto)

    then: 'validation set contains single message about empty state'
    constraintViolation.size() == 1
    constraintViolation.contains('State is required')
  }

  def 'order with blank recipient zip code is invalid'() {
    given: 'order dto with blank recipient zip code'
    OrderDto orderDto = dto(orderDefaults << [address: address(addressDefaults << [zip: ''])])

    when: 'order dto validated'
    def constraintViolation = validate(orderDto)

    then: 'validation set contains single message about empty zip code'
    constraintViolation.size() == 1
    constraintViolation.contains('Zip code is required')
  }

  def 'order with incorrect credit card number is invalid'() {
    given: 'order dto with incorrect credit card number'
    OrderDto orderDto = dto(orderDefaults << [creditCard: creditCard(creditCardDefaults << [cardNumber: '5555555555554443'])])

    when: 'order dto validated'
    def constraintViolation = validate(orderDto)

    then: 'validation set contains single message about invalid credit card number'
    constraintViolation.size() == 1
    constraintViolation.contains('Not a valid credit card number')
  }

  def 'order with incorrect card expiration date is invalid'() {
    given: 'order dto with incorrect card expiration date'
    OrderDto orderDto = dto(orderDefaults << [creditCard: creditCard(creditCardDefaults << [cardExpirationDate: '13/21'])])

    when: 'order dto validated'
    def constraintViolation = validate(orderDto)

    then: 'validation set contains single message about invalid card expiration date'
    constraintViolation.size() == 1
    constraintViolation.contains('Card expiration date must be formatted as MM/YY')
  }

  def 'order with incorrect card validation value is invalid'() {
    given: 'order dto with incorrect card validation value'
    OrderDto orderDto = dto(orderDefaults << [creditCard: creditCard(creditCardDefaults << [cardValidationValue: '1321'])])

    when: 'order dto validated'
    def constraintViolation = validate(orderDto)

    then: 'validation set contains single message about invalid card validation value'
    constraintViolation.size() == 1
    constraintViolation.contains('Invalid Card Validation Value')
  }
}
