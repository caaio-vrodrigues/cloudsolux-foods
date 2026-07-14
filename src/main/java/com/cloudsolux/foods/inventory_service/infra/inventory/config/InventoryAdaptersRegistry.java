package com.cloudsolux.foods.inventory_service.infra.inventory.config;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudsolux.foods.inventory_service.domain.inventory.model.creation.InventoryCommandFactoryPort;
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
    return persistences.stream()
      .collect(Collectors.toMap(
        InventoryPersistencePort::getKey, 
        Function.identity()
      ));
  }

  @Bean
  Map<InventoryFactoryKey, InventoryCommandFactoryPort> inventoryCreationCommandFactories(
    List<InventoryCommandFactoryPort> factories
  ) {
    return factories.stream()
      .collect(Collectors.toMap(
        InventoryCommandFactoryPort::getKey, 
        Function.identity()
      ));
  }
}