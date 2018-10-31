package org.ua.spring.tacos.tacoscloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.ua.spring.tacos.tacoscloud.domain.ModifiableOrder;

import javax.validation.Valid;

@Controller
@RequestMapping("/orders")
public class OrderController {
  private static final Logger log = LoggerFactory.getLogger(OrderController.class);

  @GetMapping("/current")
  public String orderForm(Model model) {
    model.addAttribute("modifiableOrder", new ModifiableOrder());
    return "orderForm";
  }

  @PostMapping
  public String processOrder(@Valid ModifiableOrder modifiableOrder, Errors errors, Model model) {
    if (errors.hasErrors()) {
      return "orderForm";
    }
    log.info("Order submitted: " + modifiableOrder);
    return "redirect:/";
  }
}
