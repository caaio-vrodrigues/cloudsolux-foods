package com.cloudsolux.foods.inventory_service.infra.product.util;

import org.springframework.stereotype.Component;

import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.inventory_service.domain.product.Product;
import com.cloudsolux.foods.inventory_service.domain.product.exception.ProductInvalidArgumentException;
import com.cloudsolux.foods.inventory_service.infra.product.entity.ProductEntity;

@Component
public class ProductMapper {

  public Product toDomain(ProductEntity entity) {
    if(entity == null) {
      throw new ProductInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("ProductEntity", "ProductEntity"));
    }
    return Product.builder()
      .id(entity.getId())
      .name(entity.getName())
      .model(entity.getModel())
      .brand(entity.getBrand())
      .build();
  }

  public ProductEntity toEntity(Product domain) {
    if(domain == null) {
      throw new ProductInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("ProductEntity", "Product"));
    }
    return ProductEntity.builder()
      .id(domain.getId())
      .name(domain.getName())
      .model(domain.getModel())
      .brand(domain.getBrand())
      .build();
  }
}