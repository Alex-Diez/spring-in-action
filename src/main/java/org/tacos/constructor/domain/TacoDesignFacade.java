package org.tacos.constructor.domain;

import org.tacos.constructor.domain.dto.TacoDto;

public class TacoDesignFacade {
  private TacoDto taco;

  public void addTacoDesign(TacoDto taco) {
    this.taco = taco;
  }

  public TacoDto show(String tacoName) {
    return taco;
  }
}
