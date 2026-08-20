package com.cloudsolux.foods.finances_service.infra.expense_item.util;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cloudsolux.foods.finances_service.app.expense_item.dto.ExpenseItemResponse;
import com.cloudsolux.foods.finances_service.domain.expense_item.ExpenseItem;
import com.cloudsolux.foods.finances_service.domain.expense_item.util.ExpenseItemValidationAux;

@Component
public final class ExpenseItemResponseCreator {
 
  public List<ExpenseItemResponse> toItemsResponses(
    List<ExpenseItem> items
  ) {
    ExpenseItemValidationAux.validateList(items, "ExpenseItem");

    return items.stream()
      .map(item -> {
        ExpenseItemValidationAux.validateArgument(item, "ExpenseItem");

        return ExpenseItemResponse.builder()
          .amount(item.getAmount())
          .price(item.getPrice())
          .productId(item.getProductId())
          .build();
      })
      .toList();
  }
}