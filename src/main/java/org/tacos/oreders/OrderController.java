package org.tacos.oreders;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.tacos.oreders.model.Order;

import javax.validation.Valid;

@Controller
@RequestMapping("/orders")
@SessionAttributes("order")
public class OrderController {
  private static final Logger log = LoggerFactory.getLogger(OrderController.class);

  @GetMapping("/current")
  public String orderForm(Model model) {
    model.addAttribute("order", new OrderDto());
    return "orderForm";
  }

  @PostMapping
  public String processOrder(@ModelAttribute(name = "order") @Valid OrderDto order, Errors errors) {
    if (errors.hasErrors()) {
      return "orderForm";
    }
    log.info("Order submitted: " + order);
    return "redirect:/";
  }
}
