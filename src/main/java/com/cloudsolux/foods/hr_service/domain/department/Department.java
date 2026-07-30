package com.cloudsolux.foods.hr_service.domain.department;

import java.util.Objects;

import com.cloudsolux.foods.hr_service.domain.department.util.DepartmentValidationAux;

public final class Department {

  private final Long id;
	private final String name;
  
  private Department(DepartmentBuilder builder) {
    DepartmentValidationAux.validatePositiveLong(builder.id, "id");
    DepartmentValidationAux.validateString(builder.name, "name");
    id = builder.id;
    name = builder.name;
  }

  public static class DepartmentBuilder {
    private Long id;
	  private String name;

    public DepartmentBuilder id(Long id) {
      this.id = id;
      return this;
    }

    public DepartmentBuilder name(String name) {
      this.name = name;
      return this;
    }

    public Department build() {
      return new Department(this);
    }
  }

  public static DepartmentBuilder builder() {
    return new DepartmentBuilder();
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name);
  }

  @Override
  public boolean equals(Object o) {
    if(this == o) return true;
		if(!(o instanceof Department other)) return false;
		return Objects.equals(name, other.name);
  }

  @Override
  public String toString() {
    return "Department ['id="+id+"', 'name="+name+"']";
  }
}