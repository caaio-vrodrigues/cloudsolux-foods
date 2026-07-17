package com.cloudsolux.foods.hr_service.infra.department.adapter.persistence;

import org.springframework.stereotype.Component;

import com.cloudsolux.foods.hr_service.domain.department.Department;
import com.cloudsolux.foods.hr_service.domain.department.model.persistence.DepartmentPersistence;
import com.cloudsolux.foods.hr_service.domain.department.model.persistence.DepartmentPersistenceKey;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DepartmentPersistenceAdapter implements DepartmentPersistence {
  
  @Override
  public DepartmentPersistenceKey getKey() {
    return DepartmentPersistenceKey.DEPARTMENT_PERSISTENCE;
  }

  @Override
  public void saveDepartment(Department domain) {
    throw new UnsupportedOperationException("Unimplemented method 'saveDepartment'");
  }
}