package com.cloudsolux.foods.finances_service.domain.expense.util;

import java.time.Instant;
import java.util.List;
import java.util.Map;

import com.cloudsolux.foods.finances_service.domain.expense.exception.ExpenseInvalidArgumentException;
import com.cloudsolux.foods.finances_service.domain.expense.exception.ExpenseInvalidDependencyException;
import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.global_services.domain.global.util.ValidationAux;

public final class ExpenseValidationAux {
  
  private ExpenseValidationAux() {}

  public static void validateArgument(Object argument, String argumentType) {
    ValidationAux.validateNull(
      argument, 
      () -> new ExpenseInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Expense", argumentType))
    );
  }

  public static void validateString(String value, String argumentName) {
    ValidationAux.validateString(
      value, 
      () -> new ExpenseInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Expense", argumentName)), 
      () -> new ExpenseInvalidArgumentException(GlobalMsgCreator
        .emptyArgumentMsg("Expense", argumentName))
    );
  }

  public static void validatePositive(Long value, String argumentName) {
    ValidationAux.validatePositive(
      value, 
      () -> new ExpenseInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Expense", argumentName)), 
      () -> new ExpenseInvalidArgumentException(GlobalMsgCreator
        .positiveMsg("Expense", argumentName, value))
    );
  }

  public static void validateList(List<?> list, String listType) {
    ValidationAux.validateList(
      list, 
      () -> new ExpenseInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Expense", listType)),
      () -> new ExpenseInvalidArgumentException(GlobalMsgCreator
        .emptyList("Expense", listType))
    );
  }

  public static void validateInstant(Instant purchaseDate, String argumentName) {
    ValidationAux.validateInstant(
      purchaseDate,
      () -> new ExpenseInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("Expense", argumentName)),
      () -> new ExpenseInvalidArgumentException(GlobalMsgCreator
        .invalidInstant("Expense", argumentName, purchaseDate))
    );
  }

  public static void validateDependencyResult(
    Object adapter, String dependencyName, String resultType
  ) {
    ValidationAux.validateNull(
      adapter, 
      () -> new ExpenseInvalidDependencyException(GlobalMsgCreator
        .nullDependencyResultMsg("Expense", dependencyName, resultType))
    );
  }

  public static void validateDependencyMap(Map<?, ?> dependency, String dependencyType) {
    ValidationAux.validateMap(
      dependency, 
      () -> new ExpenseInvalidDependencyException(GlobalMsgCreator
        .nullArgumentMsg("Expense", dependencyType)), 
      () -> new ExpenseInvalidDependencyException(GlobalMsgCreator
        .emptyDependencyList("Expense", dependencyType))
    );
  }
}