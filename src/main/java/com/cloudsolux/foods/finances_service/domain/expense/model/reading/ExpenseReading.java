package com.cloudsolux.foods.finances_service.domain.expense.model.reading;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cloudsolux.foods.finances_service.app.expense.dto.ExpenseResponse;

public interface ExpenseReading extends ExpenseReadingPort {
 
  Page<ExpenseResponse> findAll(Pageable pageable);
}