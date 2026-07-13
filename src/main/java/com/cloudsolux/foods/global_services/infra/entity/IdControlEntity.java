package com.cloudsolux.foods.global_services.infra.entity;

import org.springframework.data.domain.Persistable;

import com.cloudsolux.foods.global_services.model.id_control.IdControlKey;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
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
@Builder
@Getter
public class IdControlEntity implements Persistable<IdControlKey> {
  
  @Id
	@Enumerated(EnumType.STRING)
	private IdControlKey key;
	
	private Long nextValue;
	
	public void increment() {
		nextValue++;
	}

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