package com.cloudsolux.foods.finances_service.domain.expense_item.model.validation;

public interface ExpenseItemValidation extends ExpenseItemValidationPort {
  
  void validateProduct(Long productId);
}