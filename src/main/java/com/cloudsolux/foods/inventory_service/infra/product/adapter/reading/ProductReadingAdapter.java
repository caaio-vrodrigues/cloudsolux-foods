package com.cloudsolux.foods.inventory_service.infra.product.adapter.reading;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.inventory_service.app.product.dto.ProductResponse;
import com.cloudsolux.foods.inventory_service.domain.product.exception.ProductDataAccessException;
import com.cloudsolux.foods.inventory_service.domain.product.model.reading.ProductReading;
import com.cloudsolux.foods.inventory_service.domain.product.model.reading.ProductReadingKey;
import com.cloudsolux.foods.inventory_service.domain.product.util.ProductValidationAux;
import com.cloudsolux.foods.inventory_service.infra.product.repo.ProductRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public final class ProductReadingAdapter implements ProductReading {

  private final ProductRepo repo;
  
  @Override
  public ProductReadingKey getKey() {
    return ProductReadingKey.FIND_ALL;
  }

  @Override
  public Page<ProductResponse> findAll(Pageable pageable) {
    ProductValidationAux.validateArgument(pageable, "Pageable");
    
    try {
      return repo.findAllWithStock(pageable);
    }
    catch(DataAccessException e) {
      log.error(
        GlobalMsgCreator.accessFailureLogMsg("Product")+" {}", 
        e.getMessage(), 
        e
      );

      throw new ProductDataAccessException(GlobalMsgCreator
        .accessFailureMsg("Product"));
    }
  }
}