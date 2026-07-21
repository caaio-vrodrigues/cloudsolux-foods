package com.cloudsolux.foods.hr_service.app.department.handler;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloudsolux.foods.global_services.app.IdControl.handler.IdControlGeneratorHandler;
import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.hr_service.app.department.dto.DepartmentResponse;
import com.cloudsolux.foods.hr_service.domain.department.Department;
import com.cloudsolux.foods.hr_service.domain.department.command.DepartmentCreationCommand;
import com.cloudsolux.foods.hr_service.domain.department.exception.DepartmentInvalidDependencyException;
import com.cloudsolux.foods.hr_service.domain.department.model.creation.DepartmentCreation;
import com.cloudsolux.foods.hr_service.domain.department.model.persistence.DepartmentPersistence;
import com.cloudsolux.foods.hr_service.domain.department.model.validation.DepartmentValidation;
import com.cloudsolux.foods.hr_service.infra.department.entity.DepartmentEntity;
import com.cloudsolux.foods.hr_service.infra.department.util.DepartmentAdaptersGetter;
import com.cloudsolux.foods.hr_service.infra.department.util.DepartmentMapper;
import com.cloudsolux.foods.hr_service.infra.department.util.DepartmentResponseGenerator;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DepartmentCreationHandler {

  private final DepartmentAdaptersGetter adapters;
  private final IdControlGeneratorHandler idGeneration;
  private final DepartmentMapper mapper;
  private final DepartmentResponseGenerator responseGenerator;

  @Transactional
  public DepartmentResponse create(DepartmentCreationCommand command) {
    if(!(command instanceof DepartmentCreationCommand)) {
      String receivedClassName = command != null ? 
        command.getClass().getSimpleName() : "null";
      throw new DepartmentInvalidDependencyException(GlobalMsgCreator
        .invalidClassMsg("DepartmentCreationCommand", receivedClassName));
    }
    if(!(adapters instanceof DepartmentAdaptersGetter)) {
      String receivedClassName = adapters != null ? 
        adapters.getClass().getSimpleName() : "null";
      throw new DepartmentInvalidDependencyException(GlobalMsgCreator
        .invalidClassMsg("DepartmentAdaptersGetter", receivedClassName));
    }
    if(!(idGeneration instanceof IdControlGeneratorHandler)) {
      String receivedClassName = idGeneration != null ? 
        idGeneration.getClass().getSimpleName() : "null";
      throw new DepartmentInvalidDependencyException(GlobalMsgCreator
        .invalidClassMsg("IdControlGeneratorHandler", receivedClassName));
    }
    if(!(mapper instanceof DepartmentMapper)) {
      String receivedClassName = mapper != null ? 
        mapper.getClass().getSimpleName() : "null";
      throw new DepartmentInvalidDependencyException(GlobalMsgCreator
        .invalidClassMsg("DepartmentMapper", receivedClassName));
    }
    if(!(responseGenerator instanceof DepartmentResponseGenerator)){
      String receivedClassName = responseGenerator != null ? 
        responseGenerator.getClass().getSimpleName() : "null";
      throw new DepartmentInvalidDependencyException(GlobalMsgCreator
        .invalidClassMsg("DepartmentResponseGenerator", receivedClassName));
    }

    DepartmentValidation validator = (DepartmentValidation) adapters
      .getValidator(command.getValidationKey());
    if(!(validator instanceof DepartmentValidation)) {
      String receivedClassName = validator != null ? validator.getClass().getSimpleName() : "null";
      throw new DepartmentInvalidDependencyException(GlobalMsgCreator
        .invalidClassMsg("DepartmentValidation", receivedClassName));
    }
    validator.validateUniqueness(command);

    Long id = idGeneration.generateId(command.getIdGenerationKey());
    if(!(id instanceof Long)) {
      String receivedClassName = id != null ? id.getClass().getSimpleName() : "null";
      throw new DepartmentInvalidDependencyException(GlobalMsgCreator
        .invalidClassMsg("Long", receivedClassName));
    }

    DepartmentCreation factory = (DepartmentCreation) adapters.getFactory(command.getFactoryKey());
    if(!(factory instanceof DepartmentCreation)) {
      String receivedClassName = factory != null ? factory.getClass().getSimpleName() : "null";
      throw new DepartmentInvalidDependencyException(GlobalMsgCreator
        .invalidClassMsg("DepartmentCreation", receivedClassName));
    }  

    Department departmentDomain = factory.create(command, id);
    if(!(departmentDomain instanceof Department)) {
      String receivedClassName = departmentDomain != null ? 
        departmentDomain.getClass().getSimpleName() : "null";
      throw new DepartmentInvalidDependencyException(GlobalMsgCreator
        .invalidClassMsg( "Department", receivedClassName));
    }

    DepartmentPersistence persistence = (DepartmentPersistence) adapters
      .getPersistence(command.getPersistenceKey());
    if(!(persistence instanceof DepartmentPersistence)) {
      String receivedClassName = persistence != null ? persistence.getClass().getSimpleName() : "null";
      throw new DepartmentInvalidDependencyException(GlobalMsgCreator
        .invalidClassMsg("DepartmentPersistence", receivedClassName));
    }

    DepartmentEntity departmentEntity = mapper.toEntity(departmentDomain);
    if(!(departmentEntity instanceof DepartmentEntity)) {
      String receivedClassName = departmentEntity != null ? 
        departmentEntity.getClass().getSimpleName() : "null";
      throw new DepartmentInvalidDependencyException(GlobalMsgCreator
        .invalidClassMsg("DepartmentEntity", receivedClassName));
    }

    persistence.saveDepartment(departmentEntity);
    return responseGenerator.toDepartmentResponse(departmentDomain);
  }
}