package org.tacos.constructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.tacos.constructor.domain.dto.TacoDto;
import org.tacos.constructor.model.Ingredient;
import org.tacos.constructor.ports.TacoRepository;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.validation.Valid;

@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignTacoController {
  private static final Logger log = LoggerFactory.getLogger(DesignTacoController.class);

  private final TacoRepository repository;

  @Autowired
  public DesignTacoController(TacoRepository repository) {
    this.repository = repository;
  }

  @ModelAttribute(name = "taco")
  public TacoDto taco() {
    return new TacoDto();
  }

  @GetMapping
  public String showDesignForm(Model model) {
    model.addAllAttributes(
        StreamSupport.stream(repository.findAllIngredients().spliterator(), false)
            .collect(Collectors.groupingBy(Ingredient::key))
    );
    return "design";
  }

  @PostMapping
  public String processDesign(@ModelAttribute(name = "taco") @Valid TacoDto taco, Errors errors) {
    if (errors.hasErrors()) {
      return "design";
    }
    log.info("Processing: " + taco);
    return "redirect:/orders/current";
  }
}
