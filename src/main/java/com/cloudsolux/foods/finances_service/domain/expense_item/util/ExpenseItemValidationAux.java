package com.cloudsolux.foods.finances_service.domain.expense_item.util;

import java.math.BigDecimal;

import com.cloudsolux.foods.finances_service.domain.expense_item.exception.ExpenseItemInvalidArgumentException;
import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.global_services.domain.global.util.ValidationAux;

public final class ExpenseItemValidationAux {
 
  private ExpenseItemValidationAux() {}

  public static void validatePositiveBigDecimal(BigDecimal value, String argumentName) {
    ValidationAux.validatePositiveBigDecimal(
      value, 
      () -> new ExpenseItemInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("ExpenseItem", argumentName)), 
      () -> new ExpenseItemInvalidArgumentException(GlobalMsgCreator
        .positiveMsg("ExpenseItem", argumentName, value))
    );
  }

  public static void validatePositiveLong(Long value, String argumentName) {
    ValidationAux.validatePositiveLong(
      value, 
      () -> new ExpenseItemInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("ExpenseItem", argumentName)), 
      () -> new ExpenseItemInvalidArgumentException(GlobalMsgCreator
        .positiveMsg("ExpenseItem", argumentName, value))
    );
  }

  public static void validatePositiveOrZeroBigDecimal(BigDecimal amount, String argumentName) {
    ValidationAux.validatePositiveOrZeroBigDecimal(
      amount, 
      () -> new ExpenseItemInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("ExpenseItem", argumentName)), 
      () -> new ExpenseItemInvalidArgumentException(GlobalMsgCreator
        .positiveOrZeroMsg("ExpenseItem", argumentName, amount))
    );
  }

  public static void validateArgument(Object argument, String argumentType) {
    ValidationAux.validateArgument(
      argument, 
      () -> new ExpenseItemInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("ExpenseItem", argumentType))
    );
  }
}