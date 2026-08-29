package com.cloudsolux.foods.finances_service.infra.expense.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cloudsolux.foods.finances_service.app.expense.dto.ExpenseResponse;
import com.cloudsolux.foods.finances_service.infra.expense.entity.ExpenseEntity;

public interface ExpenseRepo extends JpaRepository<ExpenseEntity, Long> {
  
  @Query(
    value="""
      SELECT new com.cloudsolux.foods.finances_service.app.expense.dto.ExpenseResponse(
        e.id, e.purchaseDate, e.description
      )
      FROM ExpenseEntity e
    """,
    countQuery="""
      SELECT count(e)
      FROM ExpenseEntity e
    """
  )
  Page<ExpenseResponse> findAllPaged(Pageable pageable);
}