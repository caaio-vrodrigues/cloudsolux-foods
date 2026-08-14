package com.cloudsolux.foods.finances_service.app.expense_item.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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
public final class ExpenseItemResponse {

  @NotNull @Positive
  private Long productId;

  @NotNull @PositiveOrZero
  private BigDecimal price;

  @NotNull @PositiveOrZero
	private BigDecimal amount;
}