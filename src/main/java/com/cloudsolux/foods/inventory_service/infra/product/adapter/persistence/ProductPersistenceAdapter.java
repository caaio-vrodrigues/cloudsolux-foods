package com.cloudsolux.foods.inventory_service.infra.product.adapter.persistence;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.TransientDataAccessException;
import org.springframework.stereotype.Component;

import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.inventory_service.domain.product.Product;
import com.cloudsolux.foods.inventory_service.domain.product.exception.ProductConcurrentException;
import com.cloudsolux.foods.inventory_service.domain.product.exception.ProductInvalidArgumentException;
import com.cloudsolux.foods.inventory_service.domain.product.model.persistence.ProductPersistence;
import com.cloudsolux.foods.inventory_service.domain.product.model.persistence.ProductPersistenceKey;
import com.cloudsolux.foods.inventory_service.infra.product.entity.ProductEntity;
import com.cloudsolux.foods.inventory_service.infra.product.repo.ProductRepo;
import com.cloudsolux.foods.inventory_service.infra.product.util.ProductMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProductPersistenceAdapter implements ProductPersistence {

  private final ProductRepo repo;
  private final ProductMapper mapper;

  @Override
  public ProductPersistenceKey getKey() {
    return ProductPersistenceKey.PRODUCT_PERSISTENCE;
  }

  @Override
  public void save(Product product) {
    if(product == null) {
      throw new ProductInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("ProductEntity", "Product"));
    }
    ProductEntity entity = mapper.toEntity(product);
    try{
      repo.save(entity);
    }
    catch(DataIntegrityViolationException | TransientDataAccessException  e) {
      log.error(GlobalMsgCreator.persistenceFailureLogMsg("ProductEntity")+". {}", 
        e.getMessage(), e);
      throw new ProductConcurrentException(GlobalMsgCreator
        .persistenceFailureMsg("ProductEntity"));
    }
  }
}