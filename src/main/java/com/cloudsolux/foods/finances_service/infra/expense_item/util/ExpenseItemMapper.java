package com.cloudsolux.foods.finances_service.infra.expense_item.util;

import org.springframework.stereotype.Component;

import com.cloudsolux.foods.finances_service.domain.expense_item.ExpenseItem;
import com.cloudsolux.foods.finances_service.domain.expense_item.util.ExpenseItemValidationAux;
import com.cloudsolux.foods.finances_service.infra.expense.entity.ExpenseEntity;
import com.cloudsolux.foods.finances_service.infra.expense_item.entity.ExpenseItemEntity;

@Component
public final class ExpenseItemMapper {
 
  public ExpenseItemEntity toEntity(ExpenseItem domain, ExpenseEntity expense) {
    ExpenseItemValidationAux.validateArgument(domain, "ExpenseItem");
    ExpenseItemValidationAux.validateArgument(expense, "ExpenseEntity");

    return ExpenseItemEntity.builder()
      .id(domain.getId())
      .price(domain.getPrice())
      .amount(domain.getAmount())
      .productId(domain.getProductId())
      .expense(expense)
      .build();
  }
}