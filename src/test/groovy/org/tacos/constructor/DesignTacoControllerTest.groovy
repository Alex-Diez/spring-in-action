package org.tacos.constructor

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultActions
import org.tacos.ControllerConfiguration
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@ContextConfiguration(classes = [DesignTacoController, ControllerConfiguration])
@WebMvcTest(controllers = [DesignTacoController])
class DesignTacoControllerTest extends Specification {
  @Autowired
  private MockMvc mockMvc;

  def 'get design form'() {
    when:
    ResultActions actions = mockMvc.perform(get('/design'))

    then:
    actions
        .andExpect(status().isOk())
        .andExpect(view().name('design'))
  }

  def 'should create taco order'() {
    when:
    ResultActions actions = mockMvc.perform(post('/design').param('name', 'new taco').param('ingredients', 'FLTO'));

    then:
    actions
        .andExpect(status().is3xxRedirection())
        .andExpect(redirectedUrlTemplate('/orders/current'))
        .andExpect(view().name('redirect:/orders/current'))
  }

  def 'create taco order short name should not pass validation'() {
    when:
    ResultActions actions = mockMvc.perform(
        post('/design')
            .param('name', 'shrt')
            .param('ingredients', 'FLTO')
    )

    then:
    actions
        .andExpect(status().isOk())
        .andExpect(view().name('design'))
        .andExpect(model().attributeHasFieldErrors('taco', 'name'));
  }

  def 'create taco order without ingredients'() {
    when:
    ResultActions actions = mockMvc.perform(
        post('/design')
            .param('name', 'new taco')
    )

    then:
    actions
        .andExpect(status().isOk())
        .andExpect(view().name('design'))
        .andExpect(model().attributeHasFieldErrors('taco', 'ingredients'))
  }
}
