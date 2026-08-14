package com.cloudsolux.foods.finances_service.api.expense_item.dto;

import java.math.BigDecimal;

import com.cloudsolux.foods.finances_service.domain.expense_item.command.ExpenseItemCreationCommand;

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
@Getter
@Builder
public final class ExpenseItemCreationRequest {
  
  @NotNull @Positive
  private Long productId;

  @NotNull @PositiveOrZero
  private BigDecimal price;

  @NotNull @PositiveOrZero
	private BigDecimal amount;

  public ExpenseItemCreationCommand toCommand() {
    return ExpenseItemCreationCommand.builder()
      .productId(productId)
      .price(price)
      .amount(amount)
      .build();
  }
}