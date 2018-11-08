package org.tacos.oreders.port;

import javax.validation.constraints.NotBlank;

public interface OrderTransformerFactory<T> {
  OrderTransformer<T> createTransformer(
      String recipientName,
      String street,
      String city,
      String state,
      String zip,
      String number,
      String expirationDate,
      String cardValidationValue);
}
