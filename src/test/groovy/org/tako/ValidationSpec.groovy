package org.tako

import spock.lang.Specification

import javax.validation.Validation
import javax.validation.Validator
import java.util.stream.Collectors


class ValidationSpec extends Specification {
  protected Validator validator

  def setup() {
    def factory = Validation.buildDefaultValidatorFactory()
    validator = factory.validator
  }

  Set<String> validate(Object object) {
    validator.validate(object).stream().map({cv -> cv.message}).collect(Collectors.toSet())
  }
}
