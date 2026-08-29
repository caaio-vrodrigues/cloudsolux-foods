package com.cloudsolux.foods.finances_service.app.expense.seeder;

import java.time.Instant;
import java.util.List;

import org.springframework.context.annotation.Profile;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Profile("dev")
@AllArgsConstructor(access=AccessLevel.PRIVATE)
@NoArgsConstructor(access=AccessLevel.PROTECTED)
@Builder
@Getter
public final class ExpenseSeeder {

	private String description;
	private List<ExpenseItemSeeder> expenseItemDTOList;
	private Instant purchaseDate;
}