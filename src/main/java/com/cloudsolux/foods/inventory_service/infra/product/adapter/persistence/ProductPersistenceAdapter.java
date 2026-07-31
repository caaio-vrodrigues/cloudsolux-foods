package com.cloudsolux.foods.inventory_service.infra.product.adapter.persistence;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.inventory_service.domain.product.Product;
import com.cloudsolux.foods.inventory_service.domain.product.exception.ProductPersistenceException;
import com.cloudsolux.foods.inventory_service.domain.product.model.persistence.ProductPersistence;
import com.cloudsolux.foods.inventory_service.domain.product.model.persistence.ProductPersistenceKey;
import com.cloudsolux.foods.inventory_service.domain.product.util.ProductValidationAux;
import com.cloudsolux.foods.inventory_service.infra.product.entity.ProductEntity;
import com.cloudsolux.foods.inventory_service.infra.product.repo.ProductRepo;
import com.cloudsolux.foods.inventory_service.infra.product.util.ProductMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public final class ProductPersistenceAdapter implements ProductPersistence {

  private final ProductRepo repo;
  private final ProductMapper mapper;

  @Override
  public ProductPersistenceKey getKey() {
    return ProductPersistenceKey.PRODUCT_PERSISTENCE;
  }

  @Override
  public void save(Product product) {
    ProductValidationAux.validateArgument(product, "Product");
    ProductValidationAux.validateDependency(repo, "ProductRepo");
    ProductValidationAux.validateDependency(mapper, "ProductMapper");

    ProductEntity entity = mapper.toEntity(product);

    try{
      repo.save(entity);
    }
    catch(DataAccessException e) {
      log.error(
        GlobalMsgCreator.persistenceFailureLogMsg("Product")+". {}", 
        e.getMessage(), 
        e
      );
      throw new ProductPersistenceException(GlobalMsgCreator
        .persistenceFailureMsg("Product"));
    }
  }
}