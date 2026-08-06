package com.cloudsolux.foods.hr_service.infra.employee.util;

import org.springframework.stereotype.Component;

import com.cloudsolux.foods.hr_service.app.employee.dto.EmployeeResponse;
import com.cloudsolux.foods.hr_service.domain.employee.Employee;
import com.cloudsolux.foods.hr_service.domain.employee.util.EmployeeValidationAux;
import com.cloudsolux.foods.hr_service.domain.user_account.UserAccount;

@Component
public final class EmployeeResponseGenerator {
  
  public EmployeeResponse toEmployeeResponse(Employee domain, UserAccount userAccount) {
    EmployeeValidationAux.validateArgument(domain, "Employee");
    EmployeeValidationAux.validateArgument(userAccount, "UserAccount");

    return EmployeeResponse.builder()
      .id(domain.getId())
      .departmentId(domain.getDepartmentId())
      .userAccountId(userAccount.getId())
      .firstName(userAccount.getFirstName())
      .lastName(userAccount.getLastName())
      .birthday(userAccount.getBirthday())
      .email(userAccount.getEmail())
      .role(userAccount.getRole())
      .active(userAccount.getActive())
      .build();
  }
}