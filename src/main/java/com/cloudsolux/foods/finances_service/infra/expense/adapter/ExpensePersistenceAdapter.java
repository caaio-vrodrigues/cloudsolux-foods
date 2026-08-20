package com.cloudsolux.foods.finances_service.infra.expense.adapter;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.cloudsolux.foods.finances_service.domain.expense.Expense;
import com.cloudsolux.foods.finances_service.domain.expense.exception.ExpensePersistenceException;
import com.cloudsolux.foods.finances_service.domain.expense.model.persistence.ExpensePersistence;
import com.cloudsolux.foods.finances_service.domain.expense.model.persistence.ExpensePersistenceKey;
import com.cloudsolux.foods.finances_service.domain.expense.util.ExpenseValidationAux;
import com.cloudsolux.foods.finances_service.infra.expense.entity.ExpenseEntity;
import com.cloudsolux.foods.finances_service.infra.expense.repo.ExpenseRepo;
import com.cloudsolux.foods.finances_service.infra.expense.util.ExpenseMapper;
import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public final class ExpensePersistenceAdapter implements ExpensePersistence {

  private final ExpenseRepo repo;
  private final ExpenseMapper mapper;

  @Override
  public ExpensePersistenceKey getKey() {
    return ExpensePersistenceKey.EXPENSE_PERSISTENCE;
  }

  @Override
  public void save(List<Expense> expenses) {
    ExpenseValidationAux.validateList(expenses, "Expense");

    List<ExpenseEntity> entities = expenses.stream()
      .map(expense -> {
        ExpenseValidationAux.validateArgument(expense, "Expense");
        return mapper.toEntity(expense);
      })
      .toList();
    
    try {
      repo.saveAll(entities);
    }
    catch(DataAccessException e) {
      log.error(
        GlobalMsgCreator.persistenceFailureLogMsg("Expense")+" {}", 
        e.getMessage(), 
        e
      );
      throw new ExpensePersistenceException(GlobalMsgCreator
        .persistenceFailureMsg("Expense"));
    }
  }
}