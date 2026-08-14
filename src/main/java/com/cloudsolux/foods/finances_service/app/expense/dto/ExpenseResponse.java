package com.cloudsolux.foods.finances_service.app.expense.dto;

import java.time.Instant;
import java.util.List;

import com.cloudsolux.foods.finances_service.app.expense_item.dto.ExpenseItemResponse;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
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
public class ExpenseResponse {

  @NotNull @Positive
  private Long id;

  @NotNull
  private Instant purchaseDate;

  @NotEmpty @Valid
  private List<ExpenseItemResponse> items;

  @NotBlank
  private String description;
}