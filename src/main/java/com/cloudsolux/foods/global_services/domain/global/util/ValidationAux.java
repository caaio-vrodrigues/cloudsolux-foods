package com.cloudsolux.foods.global_services.domain.global.util;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import com.cloudsolux.foods.global_services.domain.global.model.UnitOfMeasure;

public final class ValidationAux {

  private ValidationAux() {}

  public static void validateNull(
    Object argument, 
    Supplier<RuntimeException> nullSupplier
  ) {
    if(argument == null) throw nullSupplier.get();
  }

  public static void validateString(
    String value,
    Supplier<RuntimeException> nullSupplier,
    Supplier<RuntimeException> blankSupplier
  ) {
    if(value == null) throw nullSupplier.get();
    if(value.isBlank()) throw blankSupplier.get();
  }

  public static void validatePositive(
    Long value,
    Supplier<RuntimeException> nullSupplier,
    Supplier<RuntimeException> notPositiveSupplier
  ) {
    if(value == null) throw nullSupplier.get();
    if(value < 1) throw notPositiveSupplier.get();
  }

  public static void validatePositive(
    BigDecimal value,
    Supplier<RuntimeException> nullSupplier,
    Supplier<RuntimeException> nonPositiveSupplier
  ) {
    if(value == null) throw nullSupplier.get();

    boolean nonPositiveResult = value.compareTo(BigDecimal.ZERO) < 1;
    if(nonPositiveResult) throw nonPositiveSupplier.get();
  }

  public static void validatePositiveOrZero(
    BigDecimal amount,
    Supplier<RuntimeException> nullSupplier,
    Supplier<RuntimeException> underZeroSupplier
  ) {
    if(amount == null) throw nullSupplier.get();

    boolean underZeroResult = amount.compareTo(BigDecimal.ZERO) < 0;
    if(underZeroResult) throw underZeroSupplier.get();
  }

  public static void validateMap(
    Map<?, ?> map,
    Supplier<RuntimeException> nullSupplier,
    Supplier<RuntimeException> emptySupplier
  ) {
    if(map == null) throw nullSupplier.get();
    if(map.isEmpty()) throw emptySupplier.get();
  }

  public static void validateList(
    List<?> list,
    Supplier<RuntimeException> nullSupplier,
    Supplier<RuntimeException> emptySupplier) 
  {
    if(list == null) throw nullSupplier.get();
    if(list.isEmpty()) throw emptySupplier.get();
  }

  public static void validateEmail(
    String email, 
    Supplier<RuntimeException> nullSupplier,
    Supplier<RuntimeException> invalidEmailSupplier
  ) {
    if(email == null) throw nullSupplier.get();

    boolean invalidEmail = !email.contains("@") || !(email.length() > 4);

    if(invalidEmail) throw invalidEmailSupplier.get();
  }

  public static void validateEncodedPassword(
    String encoded, 
    Supplier<RuntimeException> nullSupplier,
    Supplier<RuntimeException> blankSupplier,
    Supplier<RuntimeException> invalidPasswordSupplier
  ) {
    if(encoded == null) throw nullSupplier.get();
    if(encoded.isBlank()) throw blankSupplier.get();

    // boolean invalidPassword = 
    //   !encoded.startsWith("$2a$") && 
    //   !encoded.startsWith("$2b$") &&
    //   !encoded.startsWith("$2y$");

    // if(invalidPassword) throw invalidPasswordSupplier.get();
  }

  public static void validateAgeSixteen(
    LocalDate birthday,
    Supplier<RuntimeException> nullSupplier,
    Supplier<RuntimeException> underSixteenSupplier
  ) {
    if(birthday == null) throw nullSupplier.get();

    LocalDate minimumBirthday = LocalDate.now().minusYears(16);

    if(birthday.isAfter(minimumBirthday)) throw underSixteenSupplier.get();
  }

  public static void validateSameUnitOfMeasure(
    UnitOfMeasure current, 
    UnitOfMeasure received, 
    Supplier<RuntimeException> nullCurrentSupplier, 
    Supplier<RuntimeException> nullReceivedSupplier,
    Supplier<RuntimeException> differentUnitOfMeasureSupplier
  ) {
    if(current == null) throw nullCurrentSupplier.get();
    if(received == null) throw nullReceivedSupplier.get();

    boolean differentUnitOfMeasure = current != received;
		if(differentUnitOfMeasure) throw differentUnitOfMeasureSupplier.get();
  }

  public static void validateUnderZeroResult(
    BigDecimal current, 
    BigDecimal received, 
    Supplier<RuntimeException> nullCurrentSupplier, 
    Supplier<RuntimeException> nullReceivedSupplier, 
    Supplier<RuntimeException> insufficientAmountSupplier
  ) {
    if(current == null) throw nullCurrentSupplier.get();
    if(received == null) throw nullReceivedSupplier.get();
    
    boolean insufficientAmount = received.compareTo(current) > 0;
    if(insufficientAmount) throw insufficientAmountSupplier.get();
  }

  public static void validateExistenceById(
    Boolean existsById,
    Supplier<RuntimeException> nullSupplier, 
    Supplier<RuntimeException> notFoundSupplier
  ) {
    if(existsById == null) throw nullSupplier.get();
    if(!existsById) throw notFoundSupplier.get();
  }

  public static void validateSameLong(
    Long firstLong, 
    Long secondLong, 
    Supplier<RuntimeException> nullFirstLongSupplier, 
    Supplier<RuntimeException> nullSecondLongSupplier, 
    Supplier<RuntimeException> differentLongSupplier
  ) {
    if(firstLong == null) throw nullFirstLongSupplier.get();
    if(secondLong == null) throw nullSecondLongSupplier.get();
    if(!firstLong.equals(secondLong)) throw differentLongSupplier.get();
  }
}