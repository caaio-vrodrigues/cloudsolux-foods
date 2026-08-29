package com.cloudsolux.foods.finances_service.app.expense.seeder;

import java.math.BigDecimal;

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
public final class ExpenseItemSeeder {

	private Long productId;
	private BigDecimal price;
	private BigDecimal amount;
}