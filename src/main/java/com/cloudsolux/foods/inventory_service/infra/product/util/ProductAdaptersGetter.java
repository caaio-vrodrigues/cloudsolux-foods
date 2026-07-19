package com.cloudsolux.foods.inventory_service.infra.product.util;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.inventory_service.domain.inventory.exception.InventoryInjectionFailureException;
import com.cloudsolux.foods.inventory_service.domain.inventory.exception.InventoryInvalidArgumentException;
import com.cloudsolux.foods.inventory_service.domain.product.model.creation.ProductFactoryKey;
import com.cloudsolux.foods.inventory_service.domain.product.model.creation.ProductFactoryPort;
import com.cloudsolux.foods.inventory_service.domain.product.model.persistence.ProductPersistenceKey;
import com.cloudsolux.foods.inventory_service.domain.product.model.persistence.ProductPersistencePort;
import com.cloudsolux.foods.inventory_service.domain.product.model.validation.ProductValidationKey;
import com.cloudsolux.foods.inventory_service.domain.product.model.validation.ProductValidationPort;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProductAdaptersGetter {

  private final Map<ProductFactoryKey, ProductFactoryPort> productFactories;
  private final Map<ProductValidationKey, ProductValidationPort> productValidators;
  private final Map<ProductPersistenceKey, ProductPersistencePort> productPersistences;

  private void validateImplementations(
    Map<?, ?> bean, String beanName, String portName, Object key
  ) {
    if(bean == null)
      throw new InventoryInjectionFailureException(
        GlobalMsgCreator.nullIngectionFailureMsg(portName, beanName));
    if(bean.isEmpty())
      throw new InventoryInjectionFailureException(
        GlobalMsgCreator.emptyInjectionList(portName, beanName));
    if(key == null)
      throw new InventoryInvalidArgumentException(
        GlobalMsgCreator.nullArgumentMsg(portName, "key"));
  }

  public ProductFactoryPort getProductFactory(ProductFactoryKey key) {
    validateImplementations(
      productFactories, "productFactories", 
      "ProductFactoryPort", key
    );
    return productFactories.get(key);
  }

  public ProductValidationPort getValidator(ProductValidationKey key) {
    validateImplementations(
      productValidators, "productValidators", 
      "ProductValidationPort", key
    );
    return productValidators.get(key);
  }

  public ProductPersistencePort getPersistence(ProductPersistenceKey key) {
    validateImplementations(
      productPersistences, "productPersistences", 
      "ProductPersistencePort", key
    );
    return productPersistences.get(key);
  }
}