package com.cloudsolux.foods.finances_service.app.expense.handler;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloudsolux.foods.finances_service.app.expense.dto.ExpenseResponse;
import com.cloudsolux.foods.finances_service.app.expense_item.handler.ExpenseItemCreationHandler;
import com.cloudsolux.foods.finances_service.domain.expense.Expense;
import com.cloudsolux.foods.finances_service.domain.expense.command.ExpenseCreationCommand;
import com.cloudsolux.foods.finances_service.domain.expense.model.creation.ExpenseCreation;
import com.cloudsolux.foods.finances_service.domain.expense.model.persistence.ExpensePersistence;
import com.cloudsolux.foods.finances_service.domain.expense.model.persistence.ExpensePersistenceKey;
import com.cloudsolux.foods.finances_service.domain.expense.util.ExpenseValidationAux;
import com.cloudsolux.foods.finances_service.domain.expense_item.ExpenseItem;
import com.cloudsolux.foods.finances_service.infra.expense.util.ExpenseAdaptersGetter;
import com.cloudsolux.foods.finances_service.infra.expense.util.ExpenseResponseCreator;
import com.cloudsolux.foods.global_services.app.IdControl.handler.IdControlGeneratorHandler;
import com.cloudsolux.foods.global_services.domain.id_control.model.IdControlKey;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExpenseCreationHandler {

  private final ExpenseItemCreationHandler expenseItemHandler;
  private final IdControlGeneratorHandler idGenerator;
  private final ExpenseAdaptersGetter adapters;
  private final ExpenseResponseCreator responseFactory;
  
  @Transactional
  public List<ExpenseResponse> create(List<ExpenseCreationCommand> commands) {
    ExpenseValidationAux.validateList(commands, "List<ExpenseCreationCommand>");

    List<Expense> expenses = commands.stream()
      .map(command -> {
        ExpenseValidationAux.validateArgument(command, "ExpenseCreationCommand");

        List<ExpenseItem> items = expenseItemHandler.create(command.getItems());

        Long id = idGenerator.generateId(IdControlKey.EXPENSE_ID);

        ExpenseCreation factory = (ExpenseCreation) adapters
          .getFactory(command.getFactoryKey());

        return factory.create(command, id, items);
      })
      .toList();

    ExpensePersistence persistence = (ExpensePersistence) adapters
      .getPersistence(ExpensePersistenceKey.EXPENSE_PERSISTENCE);
    
    persistence.save(expenses);
    return responseFactory.toResponse(expenses);
  }
}