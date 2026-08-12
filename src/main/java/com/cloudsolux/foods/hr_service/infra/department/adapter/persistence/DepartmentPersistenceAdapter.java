package com.cloudsolux.foods.hr_service.infra.department.adapter.persistence;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.hr_service.domain.department.Department;
import com.cloudsolux.foods.hr_service.domain.department.exception.DepartmentPersistenceException;
import com.cloudsolux.foods.hr_service.domain.department.model.persistence.DepartmentPersistence;
import com.cloudsolux.foods.hr_service.domain.department.model.persistence.DepartmentPersistenceKey;
import com.cloudsolux.foods.hr_service.domain.department.util.DepartmentValidationAux;
import com.cloudsolux.foods.hr_service.infra.department.entity.DepartmentEntity;
import com.cloudsolux.foods.hr_service.infra.department.repo.DepartmentRepo;
import com.cloudsolux.foods.hr_service.infra.department.util.DepartmentMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public final class DepartmentPersistenceAdapter implements DepartmentPersistence {

  private final DepartmentRepo repo;
  private final DepartmentMapper mapper;
  
  @Override
  public DepartmentPersistenceKey getKey() {
    return DepartmentPersistenceKey.DEPARTMENT_PERSISTENCE;
  }

  @Override
  public void save(Department domain) {
    DepartmentEntity entity = mapper.toEntity(domain);
    DepartmentValidationAux.validateDependencyResult(
      entity, "DepartmentMapper", "DepartmentEntity");

    try{
      repo.save(entity);
    }
    catch(DataAccessException e) {
      log.error(
        GlobalMsgCreator.persistenceFailureLogMsg("Department")+" {}",
        e.getMessage(), 
        e
      );
      throw new DepartmentPersistenceException(GlobalMsgCreator
        .persistenceFailureMsg("Department"));
    }
  }
}