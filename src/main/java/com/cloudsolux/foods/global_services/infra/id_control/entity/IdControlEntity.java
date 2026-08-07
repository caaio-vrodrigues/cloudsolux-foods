package com.cloudsolux.foods.global_services.infra.id_control.entity;

import com.cloudsolux.foods.global_services.domain.id_control.model.IdControlKey;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor(access=AccessLevel.PRIVATE)
@NoArgsConstructor(access=AccessLevel.PROTECTED)
@EqualsAndHashCode(onlyExplicitlyIncluded=true)
@Entity(name="id_control")
@Table
@Builder(toBuilder=true)
@Getter
public final class IdControlEntity {

  @Version
  private Long version;
  
  @Include
  @Id
	@Enumerated(EnumType.STRING)
  @Column(name="key")
	private IdControlKey key;
	
  @Column(name="next_value", nullable=false)
	private Long nextValue;

  @Override
  public String toString() {
    return "IdControlEntity: ['key="+key+"']";
  }
}