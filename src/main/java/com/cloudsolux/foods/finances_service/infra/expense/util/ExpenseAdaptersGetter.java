package com.cloudsolux.foods.finances_service.infra.expense.util;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.cloudsolux.foods.finances_service.domain.expense.model.creation.ExpenseCreationKey;
import com.cloudsolux.foods.finances_service.domain.expense.model.creation.ExpenseCreationPort;
import com.cloudsolux.foods.finances_service.domain.expense.model.persistence.ExpensePersistenceKey;
import com.cloudsolux.foods.finances_service.domain.expense.model.persistence.ExpensePersistencePort;
import com.cloudsolux.foods.finances_service.domain.expense.util.ExpenseValidationAux;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public final class ExpenseAdaptersGetter {

  private final Map<ExpenseCreationKey, ExpenseCreationPort> expenseFactories;
  private final Map<ExpensePersistenceKey, ExpensePersistencePort> expensePersistences;

  public ExpenseCreationPort getFactory(
    ExpenseCreationKey key
  ) {
    ExpenseValidationAux.validateArgument(key, "ExpenseCreationKey");

    ExpenseValidationAux.validateDependencyMap(
      expenseFactories, 
      "Map<ExpenseCreationKey, ExpenseCreationPort>");

    ExpenseCreationPort factory = expenseFactories.get(key);

    ExpenseValidationAux.validateDependencyResult(
      factory, 
      "expenseFactories", 
      "ExpenseCreationPort");

    return factory;
  }

  public ExpensePersistencePort getPersistence(
    ExpensePersistenceKey key
  ) {
    ExpenseValidationAux.validateArgument(key, "ExpensePersistenceKey");

    ExpenseValidationAux.validateDependencyMap(
      expensePersistences, 
      "Map<ExpensePersistenceKey, ExpensePersistencePort>");

    ExpensePersistencePort persistence = expensePersistences.get(key);

    ExpenseValidationAux.validateDependencyResult(
      persistence, 
      "expensePersistences", 
      "ExpensePersistencePort" );

    return persistence;
  }
}