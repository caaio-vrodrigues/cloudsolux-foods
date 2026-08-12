package com.cloudsolux.foods.global_services.infra.id_control.util;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cloudsolux.foods.global_services.domain.id_control.IdControl;
import com.cloudsolux.foods.global_services.domain.id_control.model.IdControlKey;
import com.cloudsolux.foods.global_services.domain.id_control.util.IdControlValidationAux;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class IdControlSeeder implements ApplicationRunner {

  private final IdControlFinder finder;
  private final IdControlFactory factory;
  private final IdControlPersistence persistence;
  
  @Override
  @Transactional
  public void run(ApplicationArguments args) {
    for(IdControlKey key : IdControlKey.values()) {
      finder.findByKey(key).orElseGet(() -> {
        IdControl initial = factory.create(key, 1L);
        IdControlValidationAux.validateDependencyResult(
          initial, "IdControlFactory", "IdControl");
        return persistence.save(initial);
      });
    }
  }
}