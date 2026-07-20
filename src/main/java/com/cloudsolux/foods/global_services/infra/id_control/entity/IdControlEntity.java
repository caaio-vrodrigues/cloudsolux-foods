package com.cloudsolux.foods.global_services.infra.id_control.entity;

import org.springframework.data.domain.Persistable;

import com.cloudsolux.foods.global_services.domain.id_control.model.IdControlKey;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor(access=AccessLevel.PRIVATE)
@NoArgsConstructor(access=AccessLevel.PROTECTED)
@Entity(name="id_control")
@Table
@Builder(toBuilder=true)
@Getter
public class IdControlEntity implements Persistable<IdControlKey> {
  
  @Id
	@Enumerated(EnumType.STRING)
	private IdControlKey key;
	
  @NotNull @Positive
	private Long nextValue;

  @Transient @Default
	private boolean isNew = true;

  @Override
  public IdControlKey getId() {
    return key;
  }

  @Override
  public boolean isNew() {
    return isNew;
  }
  
  @PrePersist @PostLoad
	void markNotNew() {
		isNew = false;
	}
}