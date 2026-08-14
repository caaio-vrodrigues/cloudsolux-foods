package com.cloudsolux.foods.finances_service.domain.expense.util;

import java.util.List;

import com.cloudsolux.foods.finances_service.domain.expense.exception.ExpenseInvalidArgumentException;
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
        .nullListElementMsg("Expense", listType)),
      () -> new ExpenseInvalidArgumentException(GlobalMsgCreator
        .emptyList("Expense", listType))
    );
  }
}