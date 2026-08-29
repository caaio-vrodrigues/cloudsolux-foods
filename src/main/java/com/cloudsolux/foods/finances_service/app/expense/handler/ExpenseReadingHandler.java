package com.cloudsolux.foods.finances_service.app.expense.handler;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloudsolux.foods.finances_service.app.expense.dto.ExpenseResponse;
import com.cloudsolux.foods.finances_service.domain.expense.model.reading.ExpenseReading;
import com.cloudsolux.foods.finances_service.domain.expense.model.reading.ExpenseReadingKey;
import com.cloudsolux.foods.finances_service.domain.expense.util.ExpenseValidationAux;
import com.cloudsolux.foods.finances_service.infra.expense.util.ExpenseAdaptersGetter;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExpenseReadingHandler {

  private final ExpenseAdaptersGetter adapters;
  
  @Transactional(readOnly=true)
  public Page<ExpenseResponse> findAll(Pageable pageable) {
    ExpenseValidationAux.validateArgument(pageable, "Pageable");

    ExpenseReading reader = (ExpenseReading) adapters
      .getReader(ExpenseReadingKey.FIND_ALL);
      
    return reader.findAll(pageable);
  }
}