package com.cloudsolux.foods.global_services.domain.id_control.exception;

public final class IdControlNotFoundException extends RuntimeException {
  
  public IdControlNotFoundException(String msg) {
    super(msg);
  }
}