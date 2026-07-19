package com.cloudsolux.foods.hr_service.domain.department;

import java.math.BigDecimal;
import java.util.Objects;

import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.hr_service.domain.department.exception.DepartmentInvalidArgumentException;

public class Department {

  private final Long id;
	private final String name;
  
  private Department(DepartmentBuilder builder) {
    this.id = builder.id;
    this.name = builder.name;
  }

  public static class DepartmentBuilder {
    private Long id;
	  private String name;

    public DepartmentBuilder id(Long id) {
      if(id == null) {
        throw new DepartmentInvalidArgumentException(GlobalMsgCreator
          .nullArgumentMsg("Department", "id"));
      }
      if(id < 1) {
        throw new DepartmentInvalidArgumentException(GlobalMsgCreator
          .positiveMsg("Department", "id", BigDecimal.valueOf(id)));
      }
      this.id = id;
      return this;
    }

    public DepartmentBuilder name(String name) {
      if(name == null) {
        throw new DepartmentInvalidArgumentException(GlobalMsgCreator
          .nullArgumentMsg("Department", "name"));
      }
      if(name.isBlank()) {
        throw new DepartmentInvalidArgumentException(GlobalMsgCreator
          .emptyFieldValue("Department", "name"));
      }
      this.name = name;
      return this;
    }

    public Department build() {
      if(id == null) 
        throw new DepartmentInvalidArgumentException(GlobalMsgCreator
          .nullArgumentMsg("Department", "id"));
      if(name == null)
        throw new DepartmentInvalidArgumentException(GlobalMsgCreator
          .nullArgumentMsg("Department", "name"));
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
    return Objects.hash(id);
  }

  @Override
  public boolean equals(Object o) {
    if(this == o) return true;
		if(!(o instanceof Department other)) return false;
		return Objects.equals(id, other.id);
  }

  @Override
  public String toString() {
    return "Department ['id="+id+"', 'name="+name+"']";
  }
}