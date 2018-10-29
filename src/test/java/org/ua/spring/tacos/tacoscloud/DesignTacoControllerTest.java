package org.ua.spring.tacos.tacoscloud;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrlTemplate;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@ExtendWith(SpringExtension.class)
@WebMvcTest
class DesignTacoControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @Test
  void getTacosIngredients() throws Exception {
    mockMvc.perform(get("/design"))
        .andExpect(status().isOk())
        .andExpect(view().name("design"));
  }

  @Test
  void createTacoOrder() throws Exception {
    mockMvc.perform(
        post("/design")
            .param("name", "new taco")
            .param("ingredients", "FLTO")
    )
        .andExpect(status().is3xxRedirection())
        .andExpect(redirectedUrlTemplate("/orders/current"))
        .andExpect(view().name("redirect:/orders/current"));
  }

  @Test
  void createTacoOrder_shortName_shouldNotPassValidation() throws Exception {
    mockMvc.perform(
        post("/design")
            .param("name", "shrt")
            .param("ingredients", "FLTO")
    )
        .andExpect(status().isOk())
        .andExpect(view().name("design"))
        .andExpect(model().attributeHasFieldErrors("taco", "name"));
  }
}
