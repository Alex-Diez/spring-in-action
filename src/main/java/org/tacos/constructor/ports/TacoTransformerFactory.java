package org.tacos.constructor.ports;

import java.util.List;

public interface TacoTransformerFactory<T> {
  TacoTransformer<T> createTransformer(String name, List<String> ingredients);
}
