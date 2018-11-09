package org.tacos.constructor.ports;

import org.tacos.common.ports.Transformer;

import java.util.List;

public interface TacoTransformerFactory<T> {
  Transformer<T> createTransformer(String name, List<String> ingredients);
}
