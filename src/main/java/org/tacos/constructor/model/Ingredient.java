package org.tacos.constructor.model;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "INGREDIENT")
@Access(AccessType.FIELD)
public class Ingredient implements Serializable {
  @Id
  @Column(name = "ID")
  private String id;
  @Column(name = "NAME")
  private String name;
  @Column(name = "TYPE")
  private Type type;

  private Ingredient() {
  }

  public Ingredient(String id, String name, Type type) {
    this.id = id;
    this.name = name;
    this.type = type;
  }

  public String key() {
    return type().toString().toLowerCase();
  }

  public String id() {
    return id;
  }

  public String name() {
    return name;
  }

  public Type type() {
    return type;
  }

  public enum Type {
    WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
  }
}
