package com.cloudsolux.foods.inventory_service.domain.product.model.reading;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cloudsolux.foods.inventory_service.app.product.dto.ProductResponse;

public interface ProductReading extends ProductReadingPort {
  
  Page<ProductResponse> findAll(Pageable pageable);
}