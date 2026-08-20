package com.cloudsolux.foods.finances_service.infra.expense_item.configuration;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudsolux.foods.finances_service.domain.expense_item.model.creation.ExpenseItemCreationKey;
import com.cloudsolux.foods.finances_service.domain.expense_item.model.creation.ExpenseItemCreationPort;
import com.cloudsolux.foods.finances_service.domain.expense_item.model.validation.ExpenseItemValidationKey;
import com.cloudsolux.foods.finances_service.domain.expense_item.model.validation.ExpenseItemValidationPort;
import com.cloudsolux.foods.finances_service.domain.expense_item.util.ExpenseItemValidationAux;

@Configuration
public class ExpenseItemAdaptersRegistry {

  @Bean
  Map<ExpenseItemCreationKey, ExpenseItemCreationPort> expenseItemFactories(
    List<ExpenseItemCreationPort> factories
  ) {
    ExpenseItemValidationAux.validateRegistryCreation(factories, "ExpenseItemCreationPort");

    return factories.stream().collect(Collectors.toMap(
      ExpenseItemCreationPort::getKey, 
      Function.identity()
    ));
  }

  @Bean
  Map<ExpenseItemValidationKey, ExpenseItemValidationPort> expenseItemValidators(
    List<ExpenseItemValidationPort> validators
  ) {
    ExpenseItemValidationAux.validateRegistryCreation(validators, "ExpenseItemValidationPort");

    return validators.stream().collect(Collectors.toMap(
      ExpenseItemValidationPort::getKey, 
      Function.identity()
    ));
  }
}