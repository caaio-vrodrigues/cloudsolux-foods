package com.cloudsolux.foods.finances_service.infra.expense.util;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cloudsolux.foods.finances_service.app.expense.dto.ExpenseResponse;
import com.cloudsolux.foods.finances_service.domain.expense.Expense;
import com.cloudsolux.foods.finances_service.domain.expense.util.ExpenseValidationAux;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public final class ExpenseResponseCreator {
 
  public List<ExpenseResponse> toResponse(List<Expense> expenses) {
    ExpenseValidationAux.validateList(expenses, "Expense");

    return expenses.stream()
      .map(expense -> {
        ExpenseValidationAux.validateArgument(expense, "Expense");
        
        return ExpenseResponse.builder()
          .id(expense.getId())
          .purchaseDate(expense.getPurchaseDate())
          .description(expense.getDescription())
          .build();
      })
      .toList();
  }
}