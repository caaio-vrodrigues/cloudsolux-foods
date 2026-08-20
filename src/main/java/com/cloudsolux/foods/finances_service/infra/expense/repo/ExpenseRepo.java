package com.cloudsolux.foods.finances_service.infra.expense.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloudsolux.foods.finances_service.infra.expense.entity.ExpenseEntity;

public interface ExpenseRepo extends JpaRepository<ExpenseEntity, Long> {
  
}