package org.tacos.constructor.adapters;

import org.tacos.common.ports.Transformer;
import org.tacos.constructor.TacoDto;
import org.tacos.constructor.ports.TacoTransformerFactory;

import java.util.List;

public class DtoTacoTransformerFactory implements TacoTransformerFactory<TacoDto> {
  @Override
  public Transformer<TacoDto> createTransformer(String name, List<String> ingredients) {
    return () -> new TacoDto(name, ingredients);
  }
}
