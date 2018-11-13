package org.tacos.constructor.domain

import org.tacos.constructor.domain.dto.TacoDto
import spock.lang.Specification

import static org.tacos.constructor.model.Ingredient.Type.*

class TacoDesignSpec extends Specification {
  def 'when taco designed it should be saved in system'() {
    given: 'taco design facade'
    TacoDesignFacade facade = new TacoDesignConfiguration().tacoDesignFacade()

    when: 'taco design added'
    TacoDto tacoReceipt = new TacoDto('taco name', [CHEESE.toString(), SAUCE.toString(), PROTEIN.toString()])
    facade.addTacoDesign(tacoReceipt)

    then: 'taco receipt can be found in system'
    facade.show('taco name') == tacoReceipt
  }
}
