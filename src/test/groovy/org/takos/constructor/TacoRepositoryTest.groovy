package org.takos.constructor

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest
import org.springframework.test.context.ContextConfiguration
import org.tacos.constructor.adapters.JdbcTacoRepository
import org.tacos.constructor.model.Ingredient
import org.tacos.constructor.model.Taco
import org.tacos.constructor.ports.TacoRepository
import spock.lang.Specification

import static org.tacos.constructor.model.Ingredient.Type.PROTEIN
import static org.tacos.constructor.model.Ingredient.Type.WRAP

@ContextConfiguration(classes = [JdbcTacoRepository])
@JdbcTest
class TacoRepositoryTest extends Specification {
  @Autowired
  private TacoRepository repository

  def 'find nothing when no data in storage'() {
    when: 'retrieve taco with id that is not in storage'
    Optional<Taco> taco = repository.find(Taco.generateNextId())

    then: 'no taco found'
    taco.empty
  }

  def 'find stored taco in storage'() {
    given: 'saved taco in storage'
    String tacoId = Taco.generateNextId()
    Set<Ingredient> receipt = [
        new Ingredient('FLTO', 'Flour Tortilla', WRAP),
        new Ingredient('GRBF', 'Ground Beef', PROTEIN)
    ]
    repository.save(new Taco(tacoId, "taco name", receipt))

    when: 'retrieve taco with id that is in storage'
    Optional<Taco> taco = repository.find(tacoId)

    then: 'taco is found'
    !taco.empty
  }
}
