package com.cloudsolux.foods.inventory_service.infra.product.config;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudsolux.foods.inventory_service.domain.product.model.creation.ProductFactoryKey;
import com.cloudsolux.foods.inventory_service.domain.product.model.creation.ProductFactoryPort;
import com.cloudsolux.foods.inventory_service.domain.product.model.persistence.ProductPersistenceKey;
import com.cloudsolux.foods.inventory_service.domain.product.model.persistence.ProductPersistencePort;
import com.cloudsolux.foods.inventory_service.domain.product.model.validation.ProductValidationKey;
import com.cloudsolux.foods.inventory_service.domain.product.model.validation.ProductValidationPort;

@Configuration
public class ProductAdaptersRegistry {
  
  @Bean
  Map<ProductFactoryKey, ProductFactoryPort> productFactories(
    List<ProductFactoryPort> factories
  ) {
    return factories.stream()
      .collect(Collectors.toMap(
        ProductFactoryPort::getKey, 
        Function.identity()
      ));
  }

  @Bean
  Map<ProductValidationKey, ProductValidationPort> productValidators(
    List<ProductValidationPort> validators
  ) {
    return validators.stream()
      .collect(Collectors.toMap(
        ProductValidationPort::getKey, 
        Function.identity()
      ));
  }

  @Bean
  Map<ProductPersistenceKey, ProductPersistencePort> productPersistences(
    List<ProductPersistencePort> savers
  ) {
    return savers.stream()
      .collect(Collectors.toMap(
        ProductPersistencePort::getKey, 
        Function.identity()
      ));
  }
}