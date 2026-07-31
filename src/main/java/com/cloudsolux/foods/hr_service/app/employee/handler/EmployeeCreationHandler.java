package com.cloudsolux.foods.hr_service.app.employee.handler;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloudsolux.foods.hr_service.app.employee.dto.EmployeeResponse;
import com.cloudsolux.foods.hr_service.infra.employee.command.EmployeeCreationCommand;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeCreationHandler {
  
  @Transactional
  public EmployeeResponse create(EmployeeCreationCommand command) {
    throw new UnsupportedOperationException("Unimplemented method 'create'");
  }
}