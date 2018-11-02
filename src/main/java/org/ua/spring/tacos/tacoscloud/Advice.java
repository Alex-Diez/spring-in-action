package org.ua.spring.tacos.tacoscloud;

import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice
public class Advice {
  @InitBinder
  private void activateDirectFieldAccess(DataBinder dataBinder) {
    dataBinder.initDirectFieldAccess();
  }
}
