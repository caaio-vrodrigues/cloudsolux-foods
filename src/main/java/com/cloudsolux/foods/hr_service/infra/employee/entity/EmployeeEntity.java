package com.cloudsolux.foods.hr_service.infra.employee.entity;

import java.time.LocalDate;
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
@Table(name="employee", uniqueConstraints = {
  @UniqueConstraint(columnNames = {
      "email"
    },
    name="UK_Employee"
  )
})
@Entity
public final class EmployeeEntity {

  @Version
	private Long version;
  
  @Id
  private Long id;

  @Column(name="first_name", nullable=false, updatable=false)
  private String firstName;

  @Column(name="last_name", nullable=false, updatable=false)
  private String lastName;

  @Column(name="birthday", nullable=false, updatable=false)
  private LocalDate birthday;

  @Column(name="email", nullable=false, updatable=false)
  private String email;

  @Column(name="departmentId", nullable=false, updatable=false)
  private Long departmentId;

  @Override
  public int hashCode() {
    return Objects.hash(email);
  }

  @Override
  public boolean equals(Object o) {
    if(this == o) return true;
		if(!(o instanceof EmployeeEntity other)) return false;
		return Objects.equals(email, other.email);
  }

  @Override
  public String toString() {
    return "EmployeeEntity: ['id="+id+"', 'firstName="+firstName+"', 'lastName="+lastName+"', 'birthday="+birthday
      +"', 'email="+email+"', 'departmentId="+departmentId +"']";
  }
}