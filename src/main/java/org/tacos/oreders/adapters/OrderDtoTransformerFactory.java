package org.tacos.oreders.adapters;

import org.tacos.oreders.OrderDto;
import org.tacos.oreders.port.OrderTransformer;
import org.tacos.oreders.port.OrderTransformerFactory;

public class OrderDtoTransformerFactory implements OrderTransformerFactory<OrderDto> {
  @Override
  public OrderTransformer<OrderDto> createTransformer(
      String recipientName,
      String street,
      String city,
      String state,
      String zip,
      String number,
      String expirationDate,
      String cardValidationValue) {
    return () -> new OrderDto(recipientName, street, city, state, zip, number, expirationDate, cardValidationValue);
  }
}
