package org.tacos.constructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.tacos.constructor.model.Ingredient;
import org.tacos.constructor.model.Taco;
import org.tacos.constructor.ports.IngredientRepository;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;

@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignTacoController {
  private static final Logger log = LoggerFactory.getLogger(DesignTacoController.class);

  private final IngredientRepository repository;

  @Autowired
  public DesignTacoController(@Qualifier("jdbc") IngredientRepository repository) {
    this.repository = repository;
  }

  @ModelAttribute(name = "taco")
  public TacoDto taco() {
    return new TacoDto();
  }

  @GetMapping
  public String showDesignForm(Model model) {
    model.addAllAttributes(
        StreamSupport.stream(repository.findAll().spliterator(), false)
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
