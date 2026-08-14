package com.cloudsolux.foods.finances_service.api.expense.dto;

import java.time.Instant;
import java.util.List;

import com.cloudsolux.foods.finances_service.api.expense_item.dto.ExpenseItemCreationRequest;
import com.cloudsolux.foods.finances_service.domain.expense.command.ExpenseCreationCommand;
import com.cloudsolux.foods.finances_service.domain.expense_item.command.ExpenseItemCreationCommand;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor(access=AccessLevel.PRIVATE)
@NoArgsConstructor(access=AccessLevel.PROTECTED)
@Getter
@Builder
public final class ExpenseCreationRequest {

  @NotNull
  private Instant purchaseDate;

  @NotEmpty @Valid
  private List<ExpenseItemCreationRequest> items;

  @NotBlank
  private String description;

  public ExpenseCreationCommand toCommand() {
    List<ExpenseItemCreationCommand> itemCommands = items.stream()
      .map(ExpenseItemCreationRequest::toCommand)
      .toList();

    return ExpenseCreationCommand.builder()
      .purchaseDate(purchaseDate)
      .items(itemCommands)
      .description(description)
      .build();
  }
}