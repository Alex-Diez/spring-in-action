package org.tacos.orders

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultActions
import org.tacos.ControllerConfiguration
import org.tacos.oreders.OrderController
import org.tacos.oreders.OrderDto
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@ContextConfiguration(classes = [OrderController, ControllerConfiguration])
@WebMvcTest(controllers = [OrderController])
class OrderControllerTest extends Specification {
  @Autowired
  private MockMvc mockMvc;

  def 'process order'() {
    when: 'create order'
    ResultActions resultOfUserActions = mockMvc.perform(
        post('/orders').sessionAttr('order', new OrderDto())
            .param('recipientName', 'person name')
            .param('street', 'address street')
            .param('city', 'address city')
            .param('state', 'NY')
            .param('zip', '10001')
            .param('creditCardNumber', '5555555555554444')
            .param('creditCardExpirationDate', '10/21')
            .param('creditCardValidationValue', '123')
    )

    then: 'user is redirected to home page'
    resultOfUserActions
        .andExpect(status().is3xxRedirection())
        .andExpect(view().name('redirect:/'))
  }

  def 'process taco order with blank name should not pass validation'() {
    when: 'user create order with empty recipient name'
    ResultActions resultOfUserActions = mockMvc.perform(
        post('/orders').sessionAttr('order', new OrderDto())
            .param('recipientName', '')
            .param('street', 'address street')
            .param('city', 'address city')
            .param('state', 'NY')
            .param('zip', '10001')
            .param('creditCardNumber', '5555555555554444')
            .param('creditCardExpirationDate', '10/21')
            .param('creditCardValidationValue', '123')
    )

    then: 'user stays on current page with error'
    resultOfUserActions
        .andExpect(status().isOk())
        .andExpect(view().name('orderForm'))
        .andExpect(model().attributeHasFieldErrors('order', 'recipientName'))
  }
}
