package com.cloudsolux.foods.inventory_service.infra.product.config;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudsolux.foods.inventory_service.domain.product.model.creation.ProductCreationKey;
import com.cloudsolux.foods.inventory_service.domain.product.model.creation.ProductCreationPort;

@Configuration
public class ProductCreationRegistry {
  
  @Bean
  Map<ProductCreationKey, ProductCreationPort> productCreators(
    List<ProductCreationPort> creators
  ) {
    return creators.stream()
      .collect(Collectors.toMap(
        ProductCreationPort::getKey, 
        Function.identity()
      ));
  }
}