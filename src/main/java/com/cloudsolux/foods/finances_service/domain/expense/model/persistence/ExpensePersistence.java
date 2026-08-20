package com.cloudsolux.foods.finances_service.domain.expense.model.persistence;

import java.util.List;

import com.cloudsolux.foods.finances_service.domain.expense.Expense;

public interface ExpensePersistence extends ExpensePersistencePort {
 
  void save(List<Expense> expenses);
}