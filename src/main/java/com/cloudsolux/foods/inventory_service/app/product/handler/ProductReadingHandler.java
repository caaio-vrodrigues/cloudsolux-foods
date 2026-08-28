package com.cloudsolux.foods.inventory_service.app.product.handler;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloudsolux.foods.inventory_service.app.product.dto.ProductResponse;
import com.cloudsolux.foods.inventory_service.domain.product.model.reading.ProductReading;
import com.cloudsolux.foods.inventory_service.domain.product.model.reading.ProductReadingKey;
import com.cloudsolux.foods.inventory_service.domain.product.util.ProductValidationAux;
import com.cloudsolux.foods.inventory_service.infra.product.util.ProductAdaptersGetter;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductReadingHandler {

  private final ProductAdaptersGetter adapters;

  @Transactional(readOnly=true)
  public Page<ProductResponse> findAll(Pageable pageable) {
    ProductValidationAux.validateArgument(pageable, "Pageable");

    ProductReading reader = (ProductReading) adapters
      .getReader(ProductReadingKey.FIND_ALL);
      
    return reader.findAll(pageable);
  }
}