package org.tacos.constructor.ports;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;
import org.tacos.constructor.model.Ingredient;
import org.tacos.constructor.model.Taco;

import java.util.Optional;

@NoRepositoryBean
public interface TacoRepository extends Repository<Taco, String> {
  @Query("select t from Taco t where t.id = :id")
  Optional<Taco> find(String id);

  void save(Taco taco);

  @Query("select i from Ingredient i")
  Iterable<Ingredient> findAllIngredients();
}
