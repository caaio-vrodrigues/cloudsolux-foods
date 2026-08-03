package com.cloudsolux.foods.hr_service.infra.employee.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloudsolux.foods.hr_service.infra.employee.entity.EmployeeEntity;

public interface EmployeeRepo extends JpaRepository<EmployeeEntity, Long> {
  
}