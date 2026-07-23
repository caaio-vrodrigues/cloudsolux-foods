package com.cloudsolux.foods.global_services.domain.global.exception;

public final class GlobalInvalidArgumentException extends RuntimeException {
  
  public GlobalInvalidArgumentException(String msg) {
    super(msg);
  }
}