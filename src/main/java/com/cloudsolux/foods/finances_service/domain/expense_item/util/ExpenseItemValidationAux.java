package com.cloudsolux.foods.finances_service.domain.expense_item.util;

import java.math.BigDecimal;
import java.util.List;

import com.cloudsolux.foods.finances_service.domain.expense_item.exception.ExpenseItemInvalidArgumentException;
import com.cloudsolux.foods.finances_service.domain.expense_item.exception.ExpenseItemInvalidDependencyException;
import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.global_services.domain.global.util.ValidationAux;

public final class ExpenseItemValidationAux {
 
  private ExpenseItemValidationAux() {}

  public static void validatePositive(BigDecimal value, String argumentName) {
    ValidationAux.validatePositive(
      value, 
      () -> new ExpenseItemInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("ExpenseItem", argumentName)), 
      () -> new ExpenseItemInvalidArgumentException(GlobalMsgCreator
        .positiveMsg("ExpenseItem", argumentName, value))
    );
  }

  public static void validatePositive(Long value, String argumentName) {
    ValidationAux.validatePositive(
      value, 
      () -> new ExpenseItemInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("ExpenseItem", argumentName)), 
      () -> new ExpenseItemInvalidArgumentException(GlobalMsgCreator
        .positiveMsg("ExpenseItem", argumentName, value))
    );
  }

  public static void validatePositiveOrZero(BigDecimal amount, String argumentName) {
    ValidationAux.validatePositiveOrZero(
      amount, 
      () -> new ExpenseItemInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("ExpenseItem", argumentName)), 
      () -> new ExpenseItemInvalidArgumentException(GlobalMsgCreator
        .positiveOrZeroMsg("ExpenseItem", argumentName, amount))
    );
  }

  public static void validateArgument(Object argument, String argumentType) {
    ValidationAux.validateNull(
      argument, 
      () -> new ExpenseItemInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("ExpenseItem", argumentType))
    );
  }

  public static void validateUnderZeroResult(
    BigDecimal current, 
    BigDecimal received, 
    String currentArgumentName, 
    String receivedArgumentName
  ) {
    ValidationAux.validateUnderZeroResult(
      current, 
      received, 
      () -> new ExpenseItemInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("ExpenseItem", currentArgumentName)),
      () -> new ExpenseItemInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("ExpenseItem", receivedArgumentName)),
      () -> new ExpenseItemInvalidArgumentException(GlobalMsgCreator
        .underZeroResult("ExpenseItem", currentArgumentName, received, current)));
  }

  public static void validateRegistryCreation(List<?> implementations, String implementationsType) {
    ValidationAux.validateList(
      implementations, 
      () -> new ExpenseItemInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("ExpenseItem", implementationsType)),
      () -> new ExpenseItemInvalidDependencyException(GlobalMsgCreator
        .emptyImplementationList("ExpenseItem", implementationsType))
    );
  }

  public static void validateDependencyResult(
    Object adapter, String dependencyName, String resultType
  ) {
    ValidationAux.validateNull(
      adapter, 
      () -> new ExpenseItemInvalidDependencyException(GlobalMsgCreator
        .nullDependencyResultMsg("ExpenseItem", dependencyName, resultType))
    );
  }

  public static void validateList(List<?> list, String listType) {
    ValidationAux.validateList(
      list, 
      () -> new ExpenseItemInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("ExpenseItem", listType)),
      () -> new ExpenseItemInvalidArgumentException(GlobalMsgCreator
        .emptyList("ExpenseItem", listType))
    );
  }
}