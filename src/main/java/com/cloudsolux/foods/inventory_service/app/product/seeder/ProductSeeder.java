package com.cloudsolux.foods.inventory_service.app.product.seeder;

import org.springframework.context.annotation.Profile;

import com.cloudsolux.foods.global_services.domain.global.model.UnitOfMeasure;

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
public final class ProductSeeder {

	private String name;
	private String model;
	private String brand;
	private UnitOfMeasure unitOfMeasure;
}