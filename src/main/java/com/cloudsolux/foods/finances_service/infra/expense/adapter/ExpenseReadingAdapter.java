package com.cloudsolux.foods.finances_service.infra.expense.adapter;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.cloudsolux.foods.finances_service.app.expense.dto.ExpenseResponse;
import com.cloudsolux.foods.finances_service.domain.expense.exception.ExpenseDataAccessException;
import com.cloudsolux.foods.finances_service.domain.expense.model.reading.ExpenseReading;
import com.cloudsolux.foods.finances_service.domain.expense.model.reading.ExpenseReadingKey;
import com.cloudsolux.foods.finances_service.domain.expense.util.ExpenseValidationAux;
import com.cloudsolux.foods.finances_service.infra.expense.repo.ExpenseRepo;
import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class ExpenseReadingAdapter implements ExpenseReading {

  private final ExpenseRepo repo;
  
  @Override
  public ExpenseReadingKey getKey() {
    return ExpenseReadingKey.FIND_ALL;
  }

  @Override
  public Page<ExpenseResponse> findAll(Pageable pageable) {
    ExpenseValidationAux.validateArgument(pageable, "Pageable");

    try {
      return repo.findAllPaged(pageable);
    }
    catch(DataAccessException e) {
      log.error(
        GlobalMsgCreator.accessFailureLogMsg("Expense")+" {}", 
        e.getMessage(), 
        e
      );

      throw new ExpenseDataAccessException(GlobalMsgCreator
        .accessFailureMsg("Expense"));
    }
  } 
}