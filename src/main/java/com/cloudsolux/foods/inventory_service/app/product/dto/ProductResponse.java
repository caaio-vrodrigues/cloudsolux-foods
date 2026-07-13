package com.cloudsolux.foods.inventory_service.app.product.dto;

import java.math.BigDecimal;

import com.cloudsolux.foods.global_services.model.unit_measure.UnitOfMeasure;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor(access=AccessLevel.PRIVATE)
@NoArgsConstructor(access=AccessLevel.PROTECTED)
@Builder
@Getter
public class ProductResponse {
  
  private Long id;
  private String name;
  private String model;
  private String brand;
	private BigDecimal amount;
	private UnitOfMeasure unitOfMeasure;
}