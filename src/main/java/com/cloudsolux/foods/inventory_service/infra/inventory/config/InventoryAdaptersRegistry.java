package com.cloudsolux.foods.inventory_service.infra.inventory.config;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudsolux.foods.inventory_service.domain.inventory.model.creation.InventoryFactoryKey;
import com.cloudsolux.foods.inventory_service.domain.inventory.model.creation.InventoryFactoryPort;
import com.cloudsolux.foods.inventory_service.domain.inventory.model.validation.InventoryValidationKey;
import com.cloudsolux.foods.inventory_service.domain.inventory.model.validation.InventoryValidationPort;

@Configuration
public class InventoryAdaptersRegistry {
 
  @Bean
  Map<InventoryValidationKey, InventoryValidationPort> getInventoryValidators(
    List<InventoryValidationPort> validators
  ) {
    return validators.stream()
      .collect(Collectors.toMap(
        InventoryValidationPort::getKey, 
        Function.identity()
      ));
  }

  @Bean
  Map<InventoryFactoryKey, InventoryFactoryPort> getInventoryFactories(
    List<InventoryFactoryPort> factories
  ) {
    return factories.stream()
      .collect(Collectors.toMap(
        InventoryFactoryPort::getKey, 
        Function.identity()
      ));
  }
}