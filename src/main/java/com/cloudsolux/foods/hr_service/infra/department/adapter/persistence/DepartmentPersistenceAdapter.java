package com.cloudsolux.foods.hr_service.infra.department.adapter.persistence;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Component;

import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.hr_service.domain.department.exception.DepartmentPersistenceException;
import com.cloudsolux.foods.hr_service.domain.department.model.persistence.DepartmentPersistence;
import com.cloudsolux.foods.hr_service.domain.department.model.persistence.DepartmentPersistenceKey;
import com.cloudsolux.foods.hr_service.domain.department.util.DepartmentValidationAux;
import com.cloudsolux.foods.hr_service.infra.department.entity.DepartmentEntity;
import com.cloudsolux.foods.hr_service.infra.department.repo.DepartmentRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public final class DepartmentPersistenceAdapter implements DepartmentPersistence {

  private final DepartmentRepo repo;
  
  @Override
  public DepartmentPersistenceKey getKey() {
    return DepartmentPersistenceKey.DEPARTMENT_PERSISTENCE;
  }

  @Override
  public void saveDepartment(DepartmentEntity entity) {
    DepartmentValidationAux.validateArgument(entity, "DepartmentEntity");
    DepartmentValidationAux.validateDependency(repo, "DepartmentRepo");
    try{
      repo.save(entity);
    }
    catch(DataIntegrityViolationException | OptimisticLockingFailureException e) {
      log.error(GlobalMsgCreator.persistenceFailureLogMsg("DepartmentEntity")+" {}",
        e.getMessage(), e
      );
      throw new DepartmentPersistenceException(GlobalMsgCreator
        .persistenceFailureMsg("DepartmentEntity"));
    }
  }
}