package com.cloudsolux.foods.global_services.domain.global.exception;

public class GlobalInvalidArgumentException extends RuntimeException {
  
  public GlobalInvalidArgumentException(String msg) {
    super(msg);
  }
}