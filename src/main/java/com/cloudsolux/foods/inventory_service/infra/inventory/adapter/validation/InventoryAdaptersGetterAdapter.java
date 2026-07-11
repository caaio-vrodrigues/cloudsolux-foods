package com.cloudsolux.foods.inventory_service.infra.inventory.adapter.validation;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.cloudsolux.foods.inventory_service.domain.inventory.model.InventoryAdaptersGetter;
import com.cloudsolux.foods.inventory_service.domain.inventory.model.validation.InventoryValidationKey;
import com.cloudsolux.foods.inventory_service.domain.inventory.model.validation.InventoryValidationPort;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class InventoryAdaptersGetterAdapter implements InventoryAdaptersGetter {

  private Map<InventoryValidationKey, InventoryValidationPort> getInventoryValidators;

  @Override
  public InventoryValidationPort getValidator(InventoryValidationKey key) {
    return getInventoryValidators.get(key);
  }
}