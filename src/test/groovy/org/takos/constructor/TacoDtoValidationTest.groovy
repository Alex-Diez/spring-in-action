package org.takos.constructor

import org.tacos.constructor.TacoDto
import org.tacos.constructor.model.Ingredient
import org.takos.ValidationSpec

class TacoDtoValidationTest extends ValidationSpec {

  def 'taco dto should have name longer than four chars'() {
    given: 'taco dto with long name'
    TacoDto tacoDto = new TacoDto('long enough name', [Ingredient.Type.CHEESE.toString()])

    when: 'taco dto is validated'
    def constraintViolations = validate(tacoDto)

    then: 'taco dto is valid'
    constraintViolations.isEmpty()
  }

  def 'taco dto should be invalid when ingredient list is empty'() {
    given: 'taco without ingredient list'
    TacoDto tacoDto = new TacoDto('long enough name', [])

    when: 'taco dto is validated'
    def constraintViolations = validate(tacoDto)

    then: 'taco dto is not valid'
    constraintViolations.size() == 1
    constraintViolations.contains('You must choose at least 1 ingredient')
  }

  def 'taco dto should be invalid when name shorter than four chars'() {
    given: 'taco with short name'
    TacoDto tacoDto = new TacoDto('shrt', [Ingredient.Type.CHEESE.toString()])

    when: 'taco dto is validated'
    def constraintViolations = validate(tacoDto)

    then: 'taco dto is not valid'
    constraintViolations.size() == 1
    constraintViolations.contains('Taco name must be at least 5 characters long')
  }
}
