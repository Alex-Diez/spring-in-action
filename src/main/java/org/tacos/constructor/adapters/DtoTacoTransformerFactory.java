package org.tacos.constructor.adapters;

import org.tacos.constructor.TacoDto;
import org.tacos.constructor.ports.TacoTransformer;
import org.tacos.constructor.ports.TacoTransformerFactory;

import java.util.List;

public class DtoTacoTransformerFactory implements TacoTransformerFactory<TacoDto> {
  @Override
  public TacoTransformer<TacoDto> createTransformer(String name, List<String> ingredients) {
    return () -> new TacoDto(name, ingredients);
  }
}
