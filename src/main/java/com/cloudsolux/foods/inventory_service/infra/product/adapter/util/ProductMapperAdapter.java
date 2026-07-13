package com.cloudsolux.foods.inventory_service.infra.product.adapter.util;

import org.springframework.stereotype.Component;

import com.cloudsolux.foods.global_services.util.GlobalMsgCreator;
import com.cloudsolux.foods.inventory_service.domain.product.Product;
import com.cloudsolux.foods.inventory_service.domain.product.exception.ProductInvalidArgumentException;
import com.cloudsolux.foods.inventory_service.domain.product.model.util.ProductMapper;
import com.cloudsolux.foods.inventory_service.domain.product.model.util.ProductMapperKey;
import com.cloudsolux.foods.inventory_service.infra.product.entity.ProductEntity;

@Component
public class ProductMapperAdapter implements ProductMapper {

  @Override
  public ProductMapperKey getKey() {
    return ProductMapperKey.PRODUCT_MAPPING;
  }

  @Override
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

  @Override
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