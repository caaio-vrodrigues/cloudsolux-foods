package com.cloudsolux.foods.hr_service.infra.department.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.Version;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor(access=AccessLevel.PRIVATE)
@NoArgsConstructor(access=AccessLevel.PROTECTED)
@Builder
@Getter
@Table(name="department", uniqueConstraints = {
	@UniqueConstraint(columnNames = {
			"name"
		},
		name="UK_department"
	)
})
@Entity
public final class DepartmentEntity {
  
  @Version
	private Long version;

	@Id
	private Long id;
	
	@Column(name="name", nullable=false, updatable=false)
	private String name;

	@Override
  public int hashCode() {
    return Objects.hash(name);
  }

  @Override
  public boolean equals(Object o) {
    if(this == o) return true;
		if(!(o instanceof DepartmentEntity other)) return false;
		return Objects.equals(name, other.name);
  }

  @Override
  public String toString() {
    return "Department: ['id="+id+"', 'name="+name+"']";
  }
}