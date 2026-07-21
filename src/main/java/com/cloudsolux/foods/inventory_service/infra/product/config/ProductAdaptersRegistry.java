package com.cloudsolux.foods.inventory_service.infra.product.config;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.inventory_service.domain.product.exception.ProductInvalidArgumentException;
import com.cloudsolux.foods.inventory_service.domain.product.exception.ProductInvalidDependencyException;
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
    if(!(factories instanceof List<?>)) {
      String receivedClassName = factories != null ? 
        factories.getClass().getSimpleName() : "null";
      throw new ProductInvalidArgumentException(GlobalMsgCreator
        .invalidClassMsg("List<ProductFactoryPort>", receivedClassName));
    }
    if(factories.isEmpty()) {
      throw new ProductInvalidDependencyException(
        GlobalMsgCreator.emptyImplementationList("ProductFactoryPort"));
    }
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
    if(!(validators instanceof List<?>)) {
      String receivedClassName = validators != null ? 
        validators.getClass().getSimpleName() : "null";
      throw new ProductInvalidArgumentException(GlobalMsgCreator
        .invalidClassMsg("List<ProductValidationPort>", receivedClassName));
    }
    if(validators.isEmpty()) {
      throw new ProductInvalidDependencyException(
        GlobalMsgCreator.emptyImplementationList("ProductValidationPort"));
    }
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
    if(!(savers instanceof List<?>)) {
      String receivedClassName = savers != null ? 
        savers.getClass().getSimpleName() : "null";
      throw new ProductInvalidArgumentException(GlobalMsgCreator
        .invalidClassMsg("List<ProductPersistencePort>", receivedClassName));
    }
    if(savers.isEmpty()) {
      throw new ProductInvalidDependencyException(
        GlobalMsgCreator.emptyImplementationList("ProductPersistencePort"));
    }
    return savers.stream()
      .collect(Collectors.toMap(
        ProductPersistencePort::getKey, 
        Function.identity()
      ));
  }
}