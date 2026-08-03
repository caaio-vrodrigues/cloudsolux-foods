package com.cloudsolux.foods.hr_service.infra.employee.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode.Include;

@AllArgsConstructor(access=AccessLevel.PRIVATE)
@NoArgsConstructor(access=AccessLevel.PROTECTED)
@EqualsAndHashCode(onlyExplicitlyIncluded=true)
@Builder
@Getter
@Table(name="employee")
@Entity
public final class EmployeeEntity {

  @Version
	private Long version;
  
  @Include
  @Id
  @Column(name="id")
  private Long id;

  @Column(name="user_account_id", nullable=false)
  private Long userAccountId;

  @Column(name="department_id", nullable=false)
  private Long departmentId;

  @Override
  public String toString() {
    return "EmployeeEntity: ['id="+id+"', 'userAccountId="+userAccountId+"', 'departmentId="+departmentId+"']";
  }
}