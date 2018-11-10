package org.tacos.constructor.model;

import org.tacos.common.ports.Transformer;
import org.tacos.constructor.ports.TacoTransformerFactory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public class Taco {
  private final String id;
  private final String name;
  private final LocalDateTime createdAt;
  private final Set<Ingredient> receipt;

  public static String generateNextId() {
    return UUID.randomUUID().toString();
  }

  public Taco(String id, String name, Set<Ingredient> receipt) {
    this(id, name, receipt, LocalDateTime.now());
  }

  public Taco(String id, String name, Set<Ingredient> receipt, LocalDateTime createdAt) {
    this.id = id;
    this.name = name;
    this.receipt = receipt;
    this.createdAt = createdAt;
  }

  public String id() {
    return id;
  }

  public String name() {
    return name;
  }

  public LocalDateTime createdAt() {
    return createdAt;
  }

  public Collection<Ingredient> receipt() {
    return new ArrayList<>(receipt);
  }

  public <T> Transformer<T> transformationWith(TacoTransformerFactory<T> factory) {
    return factory.createTransformer(name, receipt.stream().map(Ingredient::getName).collect(Collectors.toList()));
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Taco taco = (Taco) o;
    return Objects.equals(name(), taco.name()) &&
        Objects.equals(receipt(), taco.receipt());
  }

  @Override
  public int hashCode() {
    return Objects.hash(name(), receipt());
  }

  @Override
  public String toString() {
    return "Taco{" +
        "name='" + name + '\'' +
        ", receipt=" + receipt +
        '}';
  }
}
