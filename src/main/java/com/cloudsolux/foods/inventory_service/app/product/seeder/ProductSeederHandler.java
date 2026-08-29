package com.cloudsolux.foods.inventory_service.app.product.seeder;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cloudsolux.foods.global_services.app.id_control.handler.IdControlGeneratorHandler;
import com.cloudsolux.foods.global_services.domain.global.model.UnitOfMeasure;
import com.cloudsolux.foods.global_services.domain.id_control.model.IdControlKey;
import com.cloudsolux.foods.inventory_service.infra.inventory.entity.InventoryEntity;
import com.cloudsolux.foods.inventory_service.infra.inventory.entity.StockEmbeddable;
import com.cloudsolux.foods.inventory_service.infra.inventory.repo.InventoryRepo;
import com.cloudsolux.foods.inventory_service.infra.product.entity.ProductEntity;
import com.cloudsolux.foods.inventory_service.infra.product.repo.ProductRepo;

import lombok.RequiredArgsConstructor;

@Profile("dev")
@Component
@RequiredArgsConstructor
public class ProductSeederHandler implements CommandLineRunner {

  private final ProductRepo repo;
  private final InventoryRepo inventoryRepo;
  private final IdControlGeneratorHandler idGenerator;

  @Override
  @Transactional
  public void run(String... args) {
    if(repo.count() < 1) seedProducts();
  }

  private void seedProducts() {
    Map<Long, UnitOfMeasure> unitByProduct = new HashMap<>();
		ProductSeederList productList = ProductSeederList.builder().build();

    List<ProductEntity> products = productList.getSeeds().stream()
      .map(dto -> {
        Long id = idGenerator.generateId(IdControlKey.CATALOG_ID);
        unitByProduct.put(id, dto.getUnitOfMeasure());
        return ProductEntity.builder()
          .id(id)
          .name(dto.getName())
          .model(dto.getModel())
          .brand(dto.getBrand())
          .build();
      })
      .collect(Collectors.toList());

    repo.saveAll(products);

    List<InventoryEntity> inventories = products.stream()
      .map(product -> InventoryEntity.builder()
        .catalogId(product.getId())
        .stock(StockEmbeddable.builder()
          .amount(BigDecimal.ONE)
          .unitOfMeasure(unitByProduct.get(product.getId()))
          .build())
        .build())
      .toList();

    inventoryRepo.saveAll(inventories);
  }
}