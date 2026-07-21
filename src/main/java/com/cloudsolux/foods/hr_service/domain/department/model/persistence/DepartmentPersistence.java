package com.cloudsolux.foods.hr_service.domain.department.model.persistence;

import com.cloudsolux.foods.hr_service.infra.department.entity.DepartmentEntity;

public interface DepartmentPersistence extends DepartmentPersistencePort {
 
  void saveDepartment(DepartmentEntity entity);
}