package com.cloudsolux.foods.inventory_service.infra.catalog;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode.Include;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(onlyExplicitlyIncluded=true)
@Inheritance(strategy=InheritanceType.JOINED)
@AllArgsConstructor(access=AccessLevel.PROTECTED)
@NoArgsConstructor(access=AccessLevel.PROTECTED)
@SuperBuilder
@Entity
@Table(name="catalog")
@Getter
public abstract class CatalogEntity {
  
  @Version
	private Long version;
	
  @Include
	@Id
	private Long id;

	@Override
  public String toString() {
    return "CatalogEntity: ['id="+id+"']";
  }
}