package com.cloudsolux.foods.inventory_service.infra.product.util;

import org.springframework.stereotype.Component;

import com.cloudsolux.foods.inventory_service.domain.product.Product;
import com.cloudsolux.foods.inventory_service.domain.product.util.ProductValidationAux;
import com.cloudsolux.foods.inventory_service.infra.product.entity.ProductEntity;

@Component
public final class ProductMapper {

  public Product toDomain(ProductEntity entity) {
    ProductValidationAux.validateArgument(entity, "ProductEntity");

    return Product.builder()
      .id(entity.getId())
      .name(entity.getName())
      .model(entity.getModel())
      .brand(entity.getBrand())
      .build();
  }

  public ProductEntity toEntity(Product domain) {
    ProductValidationAux.validateArgument(domain, "Product");

    return ProductEntity.builder()
      .id(domain.getId())
      .name(domain.getName())
      .model(domain.getModel())
      .brand(domain.getBrand())
      .build();
  }
}