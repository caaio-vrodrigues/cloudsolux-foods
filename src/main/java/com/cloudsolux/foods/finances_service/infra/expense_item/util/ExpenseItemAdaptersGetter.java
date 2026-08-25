package com.cloudsolux.foods.finances_service.infra.expense_item.util;

import java.util.Map;

import org.springframework.stereotype.Component;

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
    ExpenseItemValidationAux.validateArgument(key, "ExpenseItemCreationKey");

    ExpenseItemCreationPort factory = expenseItemFactories.get(key);

    ExpenseItemValidationAux.validateDependencyMap(
      expenseItemFactories, 
      "Map<ExpenseItemCreationKey, ExpenseItemCreationPort>");
    
    ExpenseItemValidationAux.validateDependencyResult(
      factory, 
      "expenseItemFactories", 
      "ExpenseItemCreationPort");

    return factory;
  }

  public ExpenseItemValidationPort getValidator(
    ExpenseItemValidationKey key
  ) {
    ExpenseItemValidationAux.validateArgument(key, "ExpenseItemValidationKey");

    ExpenseItemValidationAux.validateDependencyMap(
      expenseItemValidators, 
      "Map<ExpenseItemValidationKey, ExpenseItemValidationPort>");

    ExpenseItemValidationPort validator = expenseItemValidators.get(key);

    ExpenseItemValidationAux.validateDependencyResult(
      validator, 
      "expenseItemValidators", 
      "ExpenseItemValidationPort"
    );

    return validator;
  }
}