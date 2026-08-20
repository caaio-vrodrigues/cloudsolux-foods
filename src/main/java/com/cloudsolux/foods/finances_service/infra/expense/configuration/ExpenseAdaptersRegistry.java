package com.cloudsolux.foods.finances_service.infra.expense.configuration;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudsolux.foods.finances_service.domain.expense.model.creation.ExpenseCreationKey;
import com.cloudsolux.foods.finances_service.domain.expense.model.creation.ExpenseCreationPort;
import com.cloudsolux.foods.finances_service.domain.expense.model.persistence.ExpensePersistenceKey;
import com.cloudsolux.foods.finances_service.domain.expense.model.persistence.ExpensePersistencePort;

@Configuration
public class ExpenseAdaptersRegistry {
 
  @Bean
  Map<ExpenseCreationKey, ExpenseCreationPort> expenseFactories(
    List<ExpenseCreationPort> factories
  ) {
    return factories.stream().collect(Collectors.toMap(
      ExpenseCreationPort::getKey, 
      Function.identity()
    ));
  }

  @Bean
  Map<ExpensePersistenceKey, ExpensePersistencePort> expensePersistences(
    List<ExpensePersistencePort> persistences
  ) {
    return persistences.stream().collect(Collectors.toMap(
      ExpensePersistencePort::getKey, 
      Function.identity()
    ));
  }
}