package com.cloudsolux.foods.inventory_service.domain.product.model.util;

import com.cloudsolux.foods.inventory_service.domain.product.model.creation.domain.ProductFactoryKey;
import com.cloudsolux.foods.inventory_service.domain.product.model.creation.domain.ProductFactoryPort;
import com.cloudsolux.foods.inventory_service.domain.product.model.creation.dto.ProductDTOFactoryKey;
import com.cloudsolux.foods.inventory_service.domain.product.model.creation.dto.ProductDTOFactoryPort;
import com.cloudsolux.foods.inventory_service.domain.product.model.persistence.ProductPersistenceKey;
import com.cloudsolux.foods.inventory_service.domain.product.model.persistence.ProductPersistencePort;
import com.cloudsolux.foods.inventory_service.domain.product.model.validation.ProductValidationKey;
import com.cloudsolux.foods.inventory_service.domain.product.model.validation.ProductValidationPort;

public interface ProductAdaptersGetter {
  
  ProductFactoryPort getProductFactory(ProductFactoryKey key);
  ProductValidationPort getValidator(ProductValidationKey key);
  ProductPersistencePort getPersistence(ProductPersistenceKey key);
  ProductDTOFactoryPort getProductDTOFactory(ProductDTOFactoryKey key);
  ProductMapperPort getProductMapper(ProductMapperKey key);
}