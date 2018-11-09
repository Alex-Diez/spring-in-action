package org.takos

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.tacos.constructor.ports.IngredientRepository
import spock.lang.Specification
import spock.mock.DetachedMockFactory

class ControllerSpec extends Specification {

  @TestConfiguration
  static class Conf {
    DetachedMockFactory mockFactory = new DetachedMockFactory();

    @Bean
    @Qualifier("jdbc")
    IngredientRepository ingredientRepository() {
      return mockFactory.Stub(IngredientRepository);
    }
  }
}
