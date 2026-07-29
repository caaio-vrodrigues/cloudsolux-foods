package com.cloudsolux.foods.global_services.domain.global.util;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public final class ValidationAux {

  private ValidationAux() {}

  public static void validateArgument(
    Object argument, Supplier<RuntimeException> exceptionSupplier
  ) {
    if(argument == null) throw exceptionSupplier.get();
  }

  public static void validateString(
    String value,
    Supplier<RuntimeException> nullSupplier,
    Supplier<RuntimeException> blankSupplier
  ) {
    if(value == null) throw nullSupplier.get();
    if(value.isBlank()) throw blankSupplier.get();
  }

  public static void validatePositiveLong(
    Long value,
    Supplier<RuntimeException> nullSupplier,
    Supplier<RuntimeException> notPositiveSupplier
  ) {
    if(value == null) throw nullSupplier.get();
    if(value < 1) throw notPositiveSupplier.get();
  }

  public static void validatePositiveBigDecimal(
    BigDecimal value,
    Supplier<RuntimeException> nullSupplier,
    Supplier<RuntimeException> notPositiveSupplier
  ) {
    if(value == null) throw nullSupplier.get();
    if(value.compareTo(BigDecimal.ZERO) < 1) 
      throw notPositiveSupplier.get();
  }

  public static void validateDependency(
    Object dependency,
    Supplier<RuntimeException> exceptionSupplier
  ) {
    if(dependency == null) throw exceptionSupplier.get();
  }

  public static void validateDependencyMap(
    Map<?, ?> dependency,
    Supplier<RuntimeException> nullSupplier,
    Supplier<RuntimeException> emptySupplier
  ) {
    if(dependency == null) throw nullSupplier.get();
    if(dependency.isEmpty()) throw emptySupplier.get();
  }

  public static void validateRegistryCreation(
    List<?> implementations,
    Supplier<RuntimeException> nullSupplier,
    Supplier<RuntimeException> emptySupplier) 
  {
    if(implementations == null) throw nullSupplier.get();
    if(implementations.isEmpty()) throw emptySupplier.get();
  }
}