package org.tacos.oreders.port;

public interface OrderTransformer<T> {
  T transform();
}
