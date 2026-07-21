package com.cloudsolux.foods.inventory_service.infra.inventory.config;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.inventory_service.domain.inventory.exception.InventoryInvalidArgumentException;
import com.cloudsolux.foods.inventory_service.domain.inventory.exception.InventoryInvalidDependencyException;
import com.cloudsolux.foods.inventory_service.domain.inventory.model.creation.InventoryFactoryKey;
import com.cloudsolux.foods.inventory_service.domain.inventory.model.creation.InventoryFactoryPort;
import com.cloudsolux.foods.inventory_service.domain.inventory.model.persistence.InventoryPersistenceKey;
import com.cloudsolux.foods.inventory_service.domain.inventory.model.persistence.InventoryPersistencePort;

@Configuration
public class InventoryAdaptersRegistry {
  
  @Bean
  Map<InventoryFactoryKey, InventoryFactoryPort> inventoryFactories(
    List<InventoryFactoryPort> factories
  ) {
    if(!(factories instanceof List<?>)) {
      String receivedClassName = factories != null ? 
        factories.getClass().getSimpleName() : "null";
      throw new InventoryInvalidArgumentException(GlobalMsgCreator
        .invalidClassMsg("List<InventoryFactoryPort>", receivedClassName));
    }
    if(factories.isEmpty()) {
      throw new InventoryInvalidDependencyException(
        GlobalMsgCreator.emptyImplementationList("InventoryFactoryPort"));
    }
    return factories.stream()
      .collect(Collectors.toMap(
        InventoryFactoryPort::getKey, 
        Function.identity()
      ));
  }

  @Bean
  Map<InventoryPersistenceKey, InventoryPersistencePort> inventoryPersistences(
    List<InventoryPersistencePort> persistences
  ) {
    if(!(persistences instanceof List<?>)) {
      String receivedClassName = persistences != null ? 
        persistences.getClass().getSimpleName() : "null";
      throw new InventoryInvalidArgumentException(GlobalMsgCreator
        .invalidClassMsg("List<InventoryPersistencePort>", receivedClassName));
    }
    if(persistences.isEmpty()) {
      throw new InventoryInvalidDependencyException(
        GlobalMsgCreator.emptyImplementationList("InventoryPersistencePort"));
    }
    return persistences.stream()
      .collect(Collectors.toMap(
        InventoryPersistencePort::getKey, 
        Function.identity()
      ));
  }
}