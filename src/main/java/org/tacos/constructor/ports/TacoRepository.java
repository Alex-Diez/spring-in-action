package org.tacos.constructor.ports;

import org.tacos.constructor.model.Taco;

import java.util.Optional;

public interface TacoRepository {
  Optional<Taco> find(String id);

  void save(Taco taco);
}
