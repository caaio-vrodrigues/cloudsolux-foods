package com.cloudsolux.foods.inventory_service.infra.product.config;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudsolux.foods.inventory_service.domain.product.model.creation.ProductCreationKey;
import com.cloudsolux.foods.inventory_service.domain.product.model.creation.ProductCreationPort;
import com.cloudsolux.foods.inventory_service.domain.product.model.creation.ProductDTOFactoryKey;
import com.cloudsolux.foods.inventory_service.domain.product.model.creation.ProductDTOFactoryPort;
import com.cloudsolux.foods.inventory_service.domain.product.model.saving.ProductSavingKey;
import com.cloudsolux.foods.inventory_service.domain.product.model.saving.ProductSavingPort;
import com.cloudsolux.foods.inventory_service.domain.product.model.validation.ProductValidationKey;
import com.cloudsolux.foods.inventory_service.domain.product.model.validation.ProductValidationPort;

@Configuration
public class ProductAdaptersRegistry {
  
  @Bean
  Map<ProductCreationKey, ProductCreationPort> productFactories(
    List<ProductCreationPort> factories
  ) {
    return factories.stream()
      .collect(Collectors.toMap(
        ProductCreationPort::getKey, 
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
  Map<ProductSavingKey, ProductSavingPort> productSavers(
    List<ProductSavingPort> savers
  ) {
    return savers.stream()
      .collect(Collectors.toMap(
        ProductSavingPort::getKey, 
        Function.identity()
      ));
  }

  @Bean
  Map<ProductDTOFactoryKey, ProductDTOFactoryPort> productDTOFactories(
    List<ProductDTOFactoryPort> factories
  ) {
    return factories.stream()
      .collect(Collectors.toMap(
        ProductDTOFactoryPort::getKey, 
        Function.identity()
      ));
  }
}