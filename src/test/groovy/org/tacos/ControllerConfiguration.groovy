package org.tacos

import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.tacos.constructor.ports.TacoRepository
import spock.mock.DetachedMockFactory

@TestConfiguration
class ControllerConfiguration {
  DetachedMockFactory mockFactory = new DetachedMockFactory();

  @Bean
  TacoRepository ingredientRepository() {
    return mockFactory.Stub(TacoRepository);
  }
}
