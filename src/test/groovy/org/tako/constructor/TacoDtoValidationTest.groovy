package org.tako.constructor


import org.tacos.constructor.TacoDto
import org.tacos.constructor.model.Ingredient
import spock.lang.Specification

import javax.validation.Validation
import java.util.stream.Collectors

class TacoDtoValidationTest extends Specification {

  def 'taco dto should have name longer than four chars'() {
    given: 'taco dto with long name'
    def factory = Validation.buildDefaultValidatorFactory()
    def validator = factory.validator
    TacoDto tacoDto = new TacoDto('long enough name', [Ingredient.Type.CHEESE.toString()])

    expect: 'taco dto is valid'
    def constraintViolations = validator.validate(tacoDto)
    constraintViolations.isEmpty()
  }

  def 'taco dto should be invalid when ingredient list is empty'() {
    given: 'taco without ingredient list'
    def factory = Validation.buildDefaultValidatorFactory()
    def validator = factory.validator
    TacoDto tacoDto = new TacoDto('long enough name', [])

    expect: 'taco dto is not valid'
    def constraintViolations = validator.validate(tacoDto)
    constraintViolations.size() == 1
    constraintViolations.stream().map({cv -> cv.message}).collect(Collectors.toSet()).contains('You must choose at least 1 ingredient')
  }

  def 'taco dto should be invalid when name shorter than four chars'() {
    given: 'taco with short name'
    def factory = Validation.buildDefaultValidatorFactory()
    def validator = factory.validator
    TacoDto tacoDto = new TacoDto('shrt', [Ingredient.Type.CHEESE.toString()])

    expect: 'taco dto is not valid'
    def constraintViolations = validator.validate(tacoDto)
    constraintViolations.size() == 1
    constraintViolations.stream().map({cv -> cv.message}).collect(Collectors.toSet()).contains('Taco name must be at least 5 characters long')
  }
}
