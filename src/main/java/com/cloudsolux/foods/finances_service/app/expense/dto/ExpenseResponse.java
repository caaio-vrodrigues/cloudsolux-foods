package com.cloudsolux.foods.finances_service.app.expense.dto;

import java.time.Instant;
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
public class ExpenseResponse {

  @NotNull @Positive
  private Long id;

  @NotNull
  private Instant purchaseDate;

  @NotBlank
  private String description;
}