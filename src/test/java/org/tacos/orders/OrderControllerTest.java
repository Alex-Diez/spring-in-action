package org.tacos.orders;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.tacos.oreders.OrderController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@ExtendWith(SpringExtension.class)
@WebMvcTest(OrderController.class)
class OrderControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @Test
  void processOrder() throws Exception {
    mockMvc.perform(
        post("/orders")
            .param("recipientName", "person name")
            .param("street", "address street")
            .param("city", "address city")
            .param("state", "NY")
            .param("zip", "10001")
            .param("creditCardNumber", "5555555555554444")
            .param("creditCardExpirationDate", "10/21")
            .param("creditCardValidationValue", "123")
    )
        .andExpect(status().is3xxRedirection())
        .andExpect(view().name("redirect:/"));
  }

  @Test
  void processTacoOrder_blankName_shouldNotPassValidation() throws Exception {
    mockMvc.perform(
        post("/orders")
            .param("recipientName", "")
            .param("street", "address street")
            .param("city", "address city")
            .param("state", "NY")
            .param("zip", "10001")
            .param("creditCardNumber", "5555555555554444")
            .param("creditCardExpirationDate", "10/21")
            .param("creditCardValidationValue", "123")
    )
        .andExpect(status().isOk())
        .andExpect(view().name("orderForm"))
        .andExpect(model().attributeHasFieldErrors("order", "recipientName"));
  }
}