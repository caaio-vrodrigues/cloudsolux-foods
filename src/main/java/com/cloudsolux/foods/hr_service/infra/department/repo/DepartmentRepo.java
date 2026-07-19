package com.cloudsolux.foods.hr_service.infra.department.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloudsolux.foods.hr_service.infra.department.entity.DepartmentEntity;

public interface DepartmentRepo extends JpaRepository<DepartmentEntity, Long> {
  
  boolean existsByName(String name);
}