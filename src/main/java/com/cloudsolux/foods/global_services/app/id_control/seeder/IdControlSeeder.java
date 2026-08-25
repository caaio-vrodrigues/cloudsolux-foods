package com.cloudsolux.foods.global_services.app.id_control.seeder;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cloudsolux.foods.global_services.domain.id_control.IdControl;
import com.cloudsolux.foods.global_services.domain.id_control.model.IdControlKey;
import com.cloudsolux.foods.global_services.infra.id_control.util.IdControlFactory;
import com.cloudsolux.foods.global_services.infra.id_control.util.IdControlFinder;
import com.cloudsolux.foods.global_services.infra.id_control.util.IdControlPersistence;

import lombok.RequiredArgsConstructor;

@Order(1)
@Component
@RequiredArgsConstructor
public class IdControlSeeder implements ApplicationRunner {

  private final IdControlFinder finder;
  private final IdControlFactory factory;
  private final IdControlPersistence persistence;
  
  @Override
  @Transactional
  public void run(ApplicationArguments args) {
    for(IdControlKey key : IdControlKey.values()) 
      if(finder.findByKey(key).isEmpty()) {
        IdControl firstId = factory.create(key, 1L);
        persistence.save(firstId);
      }
  }
}