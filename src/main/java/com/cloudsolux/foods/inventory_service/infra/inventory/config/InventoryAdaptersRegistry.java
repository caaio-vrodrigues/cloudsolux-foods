package com.cloudsolux.foods.inventory_service.infra.inventory.config;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudsolux.foods.inventory_service.domain.inventory.model.validation.InventoryValidationKey;
import com.cloudsolux.foods.inventory_service.domain.inventory.model.validation.InventoryValidationPort;

@Configuration
public class InventoryAdaptersRegistry {
 
  @Bean
  public Map<InventoryValidationKey, InventoryValidationPort> getInventoryValidators(
    List<InventoryValidationPort> validators
  ) {
    return validators.stream()
      .collect(Collectors.toMap(
        InventoryValidationPort::getKey, 
        Function.identity()
      ));
  }
}