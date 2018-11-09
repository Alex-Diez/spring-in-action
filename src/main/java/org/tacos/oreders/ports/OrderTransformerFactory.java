package org.tacos.oreders.ports;

import org.tacos.common.ports.Transformer;

public interface OrderTransformerFactory<T> {
  Transformer<T> createTransformer(
      String recipientName,
      String street,
      String city,
      String state,
      String zip,
      String number,
      String expirationDate,
      String cardValidationValue);
}
