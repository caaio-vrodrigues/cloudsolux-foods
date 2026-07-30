package com.cloudsolux.foods.inventory_service.domain.catalog;

import java.util.Objects;

import com.cloudsolux.foods.inventory_service.domain.catalog.util.CatalogValidationAux;

public abstract class Catalog {

  private final Long id;

  protected Catalog(Long id) {
    CatalogValidationAux.validatePositiveLong(id, "id");
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public boolean equals(Object o) {
    if(this == o) return true;
		if(!(o instanceof Catalog other)) return false;
		return Objects.equals(id, other.id);
  }

  @Override
  public String toString() {
    return "Catalog: ['id="+id+"']";
  }
}