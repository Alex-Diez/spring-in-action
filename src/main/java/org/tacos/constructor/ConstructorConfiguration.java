package org.tacos.constructor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.tacos.constructor.adapters.JdbcIngredientRepository;
import org.tacos.constructor.ports.IngredientRepository;

@Configuration
public class ConstructorConfiguration {
  @Bean
  public IngredientRepository ingredientRepository(JdbcTemplate jdbc) {
    return new JdbcIngredientRepository(jdbc);
  }
}
