package com.cloudsolux.foods.inventory_service.app.product.dto;

import java.math.BigDecimal;

import com.cloudsolux.foods.global_services.domain.global.model.UnitOfMeasure;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor(access=AccessLevel.PRIVATE)
@NoArgsConstructor(access=AccessLevel.PROTECTED)
@Builder
@Getter
public final class ProductResponse {
  
  @NotNull @Positive
  private Long id;

  @NotBlank
  private String name;

  @NotBlank
  private String model;

  @NotBlank
  private String brand;

  @NotNull @Positive
	private BigDecimal amount;

  @NotNull
	private UnitOfMeasure unitOfMeasure;
}