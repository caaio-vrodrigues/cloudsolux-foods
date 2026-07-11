package com.cloudsolux.foods.inventory_service.domain.product.model;

import com.cloudsolux.foods.inventory_service.domain.product.model.creation.ProductCreationKey;
import com.cloudsolux.foods.inventory_service.domain.product.model.creation.ProductCreationPort;
import com.cloudsolux.foods.inventory_service.domain.product.model.creation.ProductDTOFactoryKey;
import com.cloudsolux.foods.inventory_service.domain.product.model.creation.ProductDTOFactoryPort;
import com.cloudsolux.foods.inventory_service.domain.product.model.saving.ProductSavingKey;
import com.cloudsolux.foods.inventory_service.domain.product.model.saving.ProductSavingPort;
import com.cloudsolux.foods.inventory_service.domain.product.model.validation.ProductValidationKey;
import com.cloudsolux.foods.inventory_service.domain.product.model.validation.ProductValidationPort;

public interface ProductAdaptersGetter {
  
  ProductCreationPort getProductFactory(ProductCreationKey key);
  ProductValidationPort getValidator(ProductValidationKey key);
  ProductSavingPort getSavers(ProductSavingKey key);
  ProductDTOFactoryPort getProductDTOFactory(ProductDTOFactoryKey key);
}