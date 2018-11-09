package org.takos.constructor

import org.tacos.common.ports.Transformer
import org.tacos.constructor.TacoDto
import org.tacos.constructor.adapters.DtoTacoTransformerFactory
import org.tacos.constructor.model.Taco

import org.tacos.constructor.ports.TacoTransformerFactory
import spock.lang.Specification

import static org.tacos.constructor.model.Ingredient.Type.CHEESE
import static org.tacos.constructor.model.Ingredient.Type.PROTEIN

class TacoDtoTransformerTest extends Specification {
  def 'should transform taco into dto object'() {
    given: 'taco and transformation factory'
    Taco taco = new Taco("name")
    taco.setIngredients([CHEESE.toString(), PROTEIN.toString()])

    TacoTransformerFactory<TacoDto> factory = new DtoTacoTransformerFactory()

    when: 'taco transformed with the factory'
    Transformer<TacoDto> transformer = taco.transformationWith(factory);

    then: 'transformer create taco transfer object'
    TacoDto tacoDto = transformer.transform();
    tacoDto != null
    tacoDto.name == "name"
    tacoDto.ingredients == [CHEESE.toString(), PROTEIN.toString()]
  }
}
