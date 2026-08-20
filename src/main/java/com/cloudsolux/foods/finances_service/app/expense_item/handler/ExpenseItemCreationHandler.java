package com.cloudsolux.foods.finances_service.app.expense_item.handler;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloudsolux.foods.finances_service.domain.expense_item.ExpenseItem;
import com.cloudsolux.foods.finances_service.domain.expense_item.command.ExpenseItemCreationCommand;
import com.cloudsolux.foods.finances_service.domain.expense_item.model.creation.ExpenseItemCreation;
import com.cloudsolux.foods.finances_service.domain.expense_item.model.validation.ExpenseItemValidation;
import com.cloudsolux.foods.finances_service.domain.expense_item.model.validation.ExpenseItemValidationKey;
import com.cloudsolux.foods.finances_service.domain.expense_item.util.ExpenseItemValidationAux;
import com.cloudsolux.foods.finances_service.infra.expense_item.util.ExpenseItemAdaptersGetter;
import com.cloudsolux.foods.global_services.app.IdControl.handler.IdControlGeneratorHandler;
import com.cloudsolux.foods.global_services.domain.id_control.model.IdControlKey;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExpenseItemCreationHandler {

  private final IdControlGeneratorHandler idGenerator;
  private final ExpenseItemAdaptersGetter adapters;

  @Transactional
  public List<ExpenseItem> create(
    List<ExpenseItemCreationCommand> commands
  ) {
    ExpenseItemValidationAux.validateList(commands, "List<ExpenseItemCreationCommand>");

    return commands.stream()
      .map(command -> {
        ExpenseItemValidationAux.validateArgument(command, "ExpenseItemCreationCommand");

        ExpenseItemValidation validator = (ExpenseItemValidation) adapters
          .getValidator(ExpenseItemValidationKey.EXPENSE_ITEM_CREATION_VALIDATION);

        validator.validateProduct(command.getProductId());

        ExpenseItemCreation factory = (ExpenseItemCreation) adapters
          .getFactory(command.getFactoryKey());

        Long id = idGenerator.generateId(IdControlKey.EXPENSE_ITEM_ID);
        
        return factory.create(command, id);
      })
      .toList();
  }
}