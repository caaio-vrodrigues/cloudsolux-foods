package com.cloudsolux.foods.hr_service.infra.employee.adapter.persistence;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.hr_service.domain.employee.Employee;
import com.cloudsolux.foods.hr_service.domain.employee.exception.EmployeePersistenceException;
import com.cloudsolux.foods.hr_service.domain.employee.model.persistence.EmployeePersistence;
import com.cloudsolux.foods.hr_service.domain.employee.model.persistence.EmployeePersistenceKey;
import com.cloudsolux.foods.hr_service.domain.employee.util.EmployeeValidationAux;
import com.cloudsolux.foods.hr_service.infra.employee.entity.EmployeeEntity;
import com.cloudsolux.foods.hr_service.infra.employee.repo.EmployeeRepo;
import com.cloudsolux.foods.hr_service.infra.employee.util.EmployeeMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public final class EmployeePersistenceAdapter implements EmployeePersistence {

  private final EmployeeMapper mapper;
  private final EmployeeRepo repo;
  
  @Override
  public EmployeePersistenceKey getKey() {
    return EmployeePersistenceKey.EMPLOYEE_PERSISTENCE;
  }

  @Override
  public void save(Employee employee) {
    EmployeeValidationAux.validateArgument(employee, "Employee");
    EmployeeValidationAux.validateDependency(mapper, "EmployeeMapper");
    EmployeeValidationAux.validateDependency(repo, "EmployeeRepo");

    EmployeeEntity entity = mapper.toEntity(employee);
    EmployeeValidationAux.validateDependency(entity, "EmployeeMapper");

    try {
      repo.save(entity);
    }
    catch(DataAccessException e) {
      log.error(
        GlobalMsgCreator.persistenceFailureLogMsg("Employee")+" {}",
        e.getMessage(),
        e
      );
      throw new EmployeePersistenceException(GlobalMsgCreator
        .persistenceFailureMsg("Employee"));
    }
  }
}