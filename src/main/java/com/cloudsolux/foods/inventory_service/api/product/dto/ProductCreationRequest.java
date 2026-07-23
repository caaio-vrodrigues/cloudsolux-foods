package com.cloudsolux.foods.inventory_service.api.product.dto;

import java.math.BigDecimal;

import com.cloudsolux.foods.global_services.domain.global.model.UnitOfMeasure;
import com.cloudsolux.foods.inventory_service.domain.product.command.ProductCreationCommand;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor(access=AccessLevel.PRIVATE)
@NoArgsConstructor(access=AccessLevel.PROTECTED)
@Builder
@Getter
public final class ProductCreationRequest {

  @NotBlank
  private String name;

  @NotBlank
  private String model;

  @NotBlank
  private String brand;

  @NotNull @PositiveOrZero
	private BigDecimal amount;
	
	@NotNull
	private UnitOfMeasure unitOfMeasure;

  public ProductCreationCommand toCommand() {
    return ProductCreationCommand.builder()
      .name(name)
      .model(model)
      .brand(brand)
      .amount(amount)
      .unitOfMeasure(unitOfMeasure)
      .build();
  }
}