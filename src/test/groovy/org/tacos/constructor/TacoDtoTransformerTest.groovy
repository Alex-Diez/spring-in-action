package org.tacos.constructor

import org.tacos.common.ports.Transformer
import org.tacos.constructor.adapters.DtoTacoTransformerFactory
import org.tacos.constructor.domain.dto.TacoDto
import org.tacos.constructor.model.Ingredient
import org.tacos.constructor.model.Taco
import org.tacos.constructor.ports.TacoTransformerFactory
import spock.lang.Specification

import static org.tacos.constructor.model.Ingredient.Type.PROTEIN
import static org.tacos.constructor.model.Ingredient.Type.WRAP

class TacoDtoTransformerTest extends Specification {
  def 'should transform taco into dto object'() {
    given: 'taco and transformation em'
    Set<Ingredient> ingredients = [
        new Ingredient('FLTO', 'Flour Tortilla', WRAP),
        new Ingredient('GRBF', 'Ground Beef', PROTEIN)
    ]
    Taco taco = new Taco(Taco.generateNextId(), "taco name", ingredients)

    TacoTransformerFactory<TacoDto> factory = new DtoTacoTransformerFactory()

    when: 'taco transformed with the em'
    Transformer<TacoDto> transformer = taco.transformationWith(factory);

    then: 'transformer create taco transfer object'
    TacoDto tacoDto = transformer.transform();
    tacoDto != null
    tacoDto.name == "taco name"
    tacoDto.ingredients == ['Flour Tortilla', 'Ground Beef']
  }
}
