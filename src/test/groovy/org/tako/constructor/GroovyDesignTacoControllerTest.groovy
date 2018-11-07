package org.tako.constructor

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.tacos.constructor.DesignTacoController
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view

@SpringBootTest(classes = [DesignTacoController])
//@WebMvcTest(controllers = [DesignTacoController])
class GroovyDesignTacoControllerTest extends Specification {
  @Autowired
  private MockMvc mockMvc;

  def 'get design form'() {
    when:
    def actions = mockMvc.perform(get('/design'))

    then:
    actions
        .andExpect(status().isOk())
        .andExpect(view().name("design"))
  }
}
