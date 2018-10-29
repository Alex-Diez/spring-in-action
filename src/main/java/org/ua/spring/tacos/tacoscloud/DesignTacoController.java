package org.ua.spring.tacos.tacoscloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.ua.spring.tacos.tacoscloud.Ingredient.Type;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

@Controller
@RequestMapping("/design")
public class DesignTacoController {
  private static final Logger log = LoggerFactory.getLogger(DesignTacoController.class);

  @GetMapping
  public String showDesignForm(Model model) {
    List<Ingredient> ingredients = Arrays.asList(
        ImmutableIngredient.builder().id("FLTO").name("Flour Tortilla").type(Type.WRAP).build(),
        ImmutableIngredient.builder().id("COTO").name("Corn Tortilla").type(Type.WRAP).build(),
        ImmutableIngredient.builder().id("GRBF").name("Ground Beef").type(Type.PROTEIN).build(),
        ImmutableIngredient.builder().id("CARN").name("Carnitas").type(Type.PROTEIN).build(),
        ImmutableIngredient.builder().id("TMTO").name("Diced Tomatoes").type(Type.VEGGIES).build(),
        ImmutableIngredient.builder().id("LETC").name("Lettuce").type(Type.VEGGIES).build(),
        ImmutableIngredient.builder().id("CHED").name("Cheddar").type(Type.CHEESE).build(),
        ImmutableIngredient.builder().id("JACK").name("Monterrey Jack").type(Type.CHEESE).build(),
        ImmutableIngredient.builder().id("SLSA").name("Salsa").type(Type.SAUCE).build(),
        ImmutableIngredient.builder().id("SRCR").name("Sour Cream").type(Type.SAUCE).build()
    );

    model.addAllAttributes(
        ingredients.stream()
            .collect(Collectors.groupingBy(Ingredient::key))
    );
    model.addAttribute("taco", new Taco());

    return "design";
  }

  @PostMapping
  public String processDesign(@Valid Taco taco, Errors errors) {
    if (errors.hasErrors()) {
      return "design";
    }
    log.info("Processing: " + taco);
    return "redirect:/orders/current";
  }
}
