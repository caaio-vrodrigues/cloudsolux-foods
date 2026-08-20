package com.cloudsolux.foods.finances_service.infra.expense.util;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cloudsolux.foods.finances_service.domain.expense.Expense;
import com.cloudsolux.foods.finances_service.domain.expense.util.ExpenseValidationAux;
import com.cloudsolux.foods.finances_service.infra.expense.entity.ExpenseEntity;
import com.cloudsolux.foods.finances_service.infra.expense_item.entity.ExpenseItemEntity;
import com.cloudsolux.foods.finances_service.infra.expense_item.util.ExpenseItemMapper;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public final class ExpenseMapper {

  private final ExpenseItemMapper itemMapper;
 
  public ExpenseEntity toEntity(Expense domain) {
    ExpenseValidationAux.validateArgument(domain, "Expense");
    
    ExpenseEntity entity = ExpenseEntity.builder()
      .id(domain.getId())
      .purchaseDate(domain.getPurchaseDate())
      .description(domain.getDescription())
      .build();

    List<ExpenseItemEntity> itemsEntities = domain.getItems().stream()
      .map(item -> {
        ExpenseValidationAux
          .validateArgument(item, "ExpenseItem");
          
        return itemMapper.toEntity(item, entity);
      })
      .toList();
    
    entity.getItems().addAll(itemsEntities);
    return entity;
  }
}