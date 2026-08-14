package com.cloudsolux.foods.finances_service.app.expense.handler;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloudsolux.foods.finances_service.app.expense.dto.ExpenseResponse;
import com.cloudsolux.foods.finances_service.domain.expense.command.ExpenseCreationCommand;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExpenseCreationHandler {
  
  @Transactional
  public List<ExpenseResponse> create(List<ExpenseCreationCommand> commands) {
    throw new UnsupportedOperationException("Unimplemented method 'create'");
  }
}