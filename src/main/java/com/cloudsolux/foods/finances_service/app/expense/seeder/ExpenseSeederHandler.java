package com.cloudsolux.foods.finances_service.app.expense.seeder;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cloudsolux.foods.finances_service.infra.expense.entity.ExpenseEntity;
import com.cloudsolux.foods.finances_service.infra.expense.repo.ExpenseRepo;
import com.cloudsolux.foods.finances_service.infra.expense_item.entity.ExpenseItemEntity;
import com.cloudsolux.foods.global_services.app.id_control.handler.IdControlGeneratorHandler;
import com.cloudsolux.foods.global_services.domain.id_control.model.IdControlKey;

import lombok.RequiredArgsConstructor;

@Profile("dev")
@Component
@RequiredArgsConstructor
public class ExpenseSeederHandler implements CommandLineRunner {

    private final ExpenseRepo expenseRepo;
    private final IdControlGeneratorHandler idGenerator;

    @Transactional
    @Override
    public void run(String... args) {
      if(expenseRepo.count() < 1) seedExpenses();
    }

    private void seedExpenses() {
      List<ExpenseSeeder> dtos = ExpenseSeederList.builder()
        .build()
        .getDtos();

      List<ExpenseEntity> entities = dtos.stream()
        .map(dto -> {
          ExpenseEntity expense = ExpenseEntity.builder()
            .id(idGenerator.generateId(IdControlKey.EXPENSE_ID))
            .purchaseDate(dto.getPurchaseDate())
            .description(dto.getDescription())
            .build();

          List<ExpenseItemEntity> itemList = dto.getExpenseItemDTOList().stream()
            .map(itemDTO -> ExpenseItemEntity.builder()
              .id(idGenerator.generateId(IdControlKey.EXPENSE_ITEM_ID))
              .productId(itemDTO.getProductId())
              .price(itemDTO.getPrice())
              .amount(itemDTO.getAmount())
              .expense(expense)
              .build())
            .toList();

          expense.getItems().addAll(itemList);
          return expense;
        })
        .toList();

      expenseRepo.saveAll(entities);
    }
}