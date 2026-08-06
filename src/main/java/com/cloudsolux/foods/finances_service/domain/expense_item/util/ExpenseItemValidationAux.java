package com.cloudsolux.foods.finances_service.domain.expense_item.util;

import java.math.BigDecimal;

import com.cloudsolux.foods.finances_service.domain.expense_item.exception.ExpenseItemInvalidArgumentException;
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
}