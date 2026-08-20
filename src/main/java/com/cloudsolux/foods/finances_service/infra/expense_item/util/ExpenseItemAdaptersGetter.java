package com.cloudsolux.foods.finances_service.infra.expense_item.util;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.cloudsolux.foods.finances_service.domain.expense.util.ExpenseValidationAux;
import com.cloudsolux.foods.finances_service.domain.expense_item.model.creation.ExpenseItemCreationKey;
import com.cloudsolux.foods.finances_service.domain.expense_item.model.creation.ExpenseItemCreationPort;
import com.cloudsolux.foods.finances_service.domain.expense_item.model.validation.ExpenseItemValidationKey;
import com.cloudsolux.foods.finances_service.domain.expense_item.model.validation.ExpenseItemValidationPort;
import com.cloudsolux.foods.finances_service.domain.expense_item.util.ExpenseItemValidationAux;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public final class ExpenseItemAdaptersGetter {

  private final Map<ExpenseItemCreationKey, ExpenseItemCreationPort> expenseItemFactories;
  private final Map<ExpenseItemValidationKey, ExpenseItemValidationPort> expenseItemValidators;
  
  public ExpenseItemCreationPort getFactory(
    ExpenseItemCreationKey key
  ) {
    ExpenseItemCreationPort implementation = expenseItemFactories.get(key);
    
    ExpenseItemValidationAux.validateDependencyResult(
      implementation, 
      "Map<ExpenseItemCreationKey, ExpenseItemCreationPort>", 
      "ExpenseItemCreationPort");

    return implementation;
  }

  public ExpenseItemValidationPort getValidator(
    ExpenseItemValidationKey key
  ) {
    ExpenseValidationAux.validateArgument(key, "ExpenseValidationKey");

    ExpenseItemValidationPort validator = expenseItemValidators.get(key);

    ExpenseValidationAux.validateDependencyResult(
      validator, 
      "Map<ExpenseValidationKey, ExpenseValidationPort>", 
      "ExpenseValidationPort"
    );

    return validator;
  }
}