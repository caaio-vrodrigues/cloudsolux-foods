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
import com.cloudsolux.foods.inventory_service.domain.product.model.reading.ProductReadingKey;
import com.cloudsolux.foods.inventory_service.domain.product.model.reading.ProductReadingPort;
import com.cloudsolux.foods.inventory_service.domain.product.model.validation.ProductValidationKey;
import com.cloudsolux.foods.inventory_service.domain.product.model.validation.ProductValidationPort;
import com.cloudsolux.foods.inventory_service.domain.product.util.ProductValidationAux;

@Configuration
public class ProductAdaptersRegistry {
  
  @Bean
  Map<ProductFactoryKey, ProductFactoryPort> productFactories(
    List<ProductFactoryPort> factories
  ) {
    ProductValidationAux.validateRegistryCreation(factories, "ProductFactoryPort");
    
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
    ProductValidationAux.validateRegistryCreation(validators, "ProductValidationPort");

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
    ProductValidationAux.validateRegistryCreation(savers, "ProductPersistencePort");

    return savers.stream()
      .collect(Collectors.toMap(
        ProductPersistencePort::getKey, 
        Function.identity()
      ));
  }

  @Bean
  Map<ProductReadingKey, ProductReadingPort> productReaders(
    List<ProductReadingPort> readers
  ) {
    ProductValidationAux.validateRegistryCreation(readers, "ProductReadingPort");

    return readers.stream()
      .collect(Collectors.toMap(
        ProductReadingPort::getKey, 
        Function.identity()
      ));
  }
}