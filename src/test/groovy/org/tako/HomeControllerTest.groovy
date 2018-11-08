package org.tako


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultActions
import org.tacos.TacosCloudApplication
import org.tacos.constructor.ports.IngredientRepository
import spock.lang.Specification
import spock.mock.DetachedMockFactory

import static org.hamcrest.Matchers.containsString
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@WebMvcTest
@ContextConfiguration(classes = TacosCloudApplication)
class HomeControllerTest extends ControllerSpec {
  @Autowired
  private MockMvc mockMvc;

  def 'render home page'() {
    when: 'get home page'
    ResultActions actions = mockMvc.perform(get("/"))

    then: 'home view is rendered'
    actions
        .andExpect(status().isOk())
        .andExpect(view().name("home"))
        .andExpect(content().string(containsString("Welcome to...")));
  }
}
