package com.cloudsolux.foods.global_services.model.id_control;

public interface IdGenerator {
  
  Long getId(IdControlKey key);
}