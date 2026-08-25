package com.cloudsolux.foods.hr_service.app.security.seeder;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cloudsolux.foods.global_services.domain.global.model.Role;
import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.hr_service.app.department.dto.DepartmentResponse;
import com.cloudsolux.foods.hr_service.app.department.handler.DepartmentCreationHandler;
import com.cloudsolux.foods.hr_service.app.employee.handler.EmployeeCreationHandler;
import com.cloudsolux.foods.hr_service.domain.department.command.DepartmentCreationCommand;
import com.cloudsolux.foods.hr_service.domain.employee.command.EmployeeCreationCommand;
import com.cloudsolux.foods.hr_service.domain.user_account.command.UserAccountCreationCommand;
import com.cloudsolux.foods.hr_service.domain.user_account.exception.UserAccountDataAccessException;
import com.cloudsolux.foods.hr_service.infra.user_account.repo.UserAccountRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Order(2)
@Slf4j
@Component
@RequiredArgsConstructor
public class UserMasterSeeder implements CommandLineRunner {
  
  private final UserAccountRepo userAccountRepo;
  private final DepartmentCreationHandler departmentCreator;
  private final EmployeeCreationHandler employeeCreator;

  @Override
  @Transactional
  public void run(String... args) throws Exception {
    String adminEmail = "admin@test.com";
    boolean emailNotFound = false;

    try{
      emailNotFound = userAccountRepo
        .findByEmail(adminEmail)
        .isEmpty();
    }
    catch(DataAccessException e) {
      log.error(
        GlobalMsgCreator.accessFailureLogMsg("UserAccount")+" {}",
        e.getMessage(),
        e
      );
      
      throw new UserAccountDataAccessException(GlobalMsgCreator
        .accessFailureMsg("UserAccount"));
    }

    if(emailNotFound) userMasterSeeder(adminEmail);
  }

  private void userMasterSeeder(String adminEmail) {
    DepartmentCreationCommand departmentCommand = DepartmentCreationCommand.builder()
      .name("administração")
      .build();
      
    DepartmentResponse department = departmentCreator.create(departmentCommand);

    UserAccountCreationCommand userAccountCommand = UserAccountCreationCommand.builder()
      .firstName("Caio Vinicius")
      .lastName("Rodrigues")
      .birthday(LocalDate.of(1992, 3, 20))
      .email(adminEmail)
      .password("admin1234")
      .active(true)
      .role(Role.ADMIN)
      .build();

    EmployeeCreationCommand employeeCommand = EmployeeCreationCommand.builder()
      .departmentId(department.getId())
      .build();
      
    employeeCreator.create(employeeCommand, userAccountCommand);
  }
}