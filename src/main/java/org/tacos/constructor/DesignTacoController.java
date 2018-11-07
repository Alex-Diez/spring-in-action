package org.tacos.constructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.tacos.constructor.model.Taco;
import org.tacos.constructor.model.Ingredient;
import org.tacos.constructor.model.Ingredient.Type;
import org.tacos.constructor.ports.IngredientRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import javax.validation.Valid;

@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignTacoController {
  private static final Logger log = LoggerFactory.getLogger(DesignTacoController.class);

  private final IngredientRepository repository;

  @Autowired
  public DesignTacoController(IngredientRepository repository) {
    this.repository = repository;
  }

  @GetMapping
  public String showDesignForm(Model model) {
//    List<Ingredient> ingredients = new ArrayList<Ingredient>(repository.findAll());

    model.addAllAttributes(
        StreamSupport.stream(repository.findAll().spliterator(), false)
            .collect(Collectors.groupingBy(Ingredient::key))
    );
    model.addAttribute("taco", new Taco());

    return "design";
  }

  @PostMapping
  public String processDesign(@Valid Taco taco, Errors errors, Model model) {
    if (errors.hasErrors()) {
      return "design";
    }
    log.info("Processing: " + taco);
    return "redirect:/orders/current";
  }
}
