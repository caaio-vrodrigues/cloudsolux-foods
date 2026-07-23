package com.cloudsolux.foods.hr_service.infra.department.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
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
@Builder
@Getter
@Table(name="department", uniqueConstraints = {
	@UniqueConstraint(columnNames = {
		"name"
	},
	name="UK_department")
})
@Entity
public final class DepartmentEntity {
  
  @Version
	private Long version;

	@Id
	@Include
	private Long id;
	
	@Column(name="name", nullable=false, updatable=false)
	private String name;

  @Override
  public String toString() {
    return "DepartmentEntity ['id="+id+"', 'name="+name+"']";
  }
}