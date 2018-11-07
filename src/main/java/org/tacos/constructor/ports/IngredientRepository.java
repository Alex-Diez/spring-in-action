package org.tacos.constructor.ports;

import org.tacos.constructor.model.Ingredient;

public interface IngredientRepository {
  Iterable<Ingredient> findAll();

  Ingredient findOne(String id);

  Ingredient save(Ingredient ingredient);
}
