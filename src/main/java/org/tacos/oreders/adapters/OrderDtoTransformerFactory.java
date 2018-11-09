package org.tacos.oreders.adapters;

import org.tacos.common.ports.Transformer;
import org.tacos.oreders.OrderDto;
import org.tacos.oreders.ports.OrderTransformerFactory;

public class OrderDtoTransformerFactory implements OrderTransformerFactory<OrderDto> {
  @Override
  public Transformer<OrderDto> createTransformer(
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
