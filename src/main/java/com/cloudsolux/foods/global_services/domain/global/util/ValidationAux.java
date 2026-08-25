package com.cloudsolux.foods.global_services.domain.global.util;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.regex.Pattern;

import com.cloudsolux.foods.global_services.domain.global.exception.GlobalInvalidArgumentException;
import com.cloudsolux.foods.global_services.domain.global.model.UnitOfMeasure;

public final class ValidationAux {

  private static final Pattern EMAIL_PATTERN =
    Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");

  private static void validateSupplier(Object supplier, String argumentName) {
    if(supplier == null) throw new GlobalInvalidArgumentException(GlobalMsgCreator
      .nullArgumentMsg("ValidationAux", argumentName));
  }

  private ValidationAux() {}

  public static void validateNull(
    Object argument, 
    Supplier<RuntimeException> nullSupplier
  ) {
    validateSupplier(nullSupplier, "nullSupplier");
    if(argument == null) throw nullSupplier.get();
  }

  public static void validateString(
    String value,
    Supplier<RuntimeException> nullSupplier,
    Supplier<RuntimeException> blankSupplier
  ) {
    validateSupplier(nullSupplier, "nullSupplier");
    validateSupplier(blankSupplier, "blankSupplier");

    if(value == null) throw nullSupplier.get();
    if(value.isBlank()) throw blankSupplier.get();
  }

  public static void validatePositive(
    Long value,
    Supplier<RuntimeException> nullSupplier,
    Supplier<RuntimeException> nonPositiveSupplier
  ) {
    validateSupplier(nullSupplier, "nullSupplier");
    validateSupplier(nonPositiveSupplier, "nonPositiveSupplier");

    if(value == null) throw nullSupplier.get();
    if(value < 1) throw nonPositiveSupplier.get();
  }

  public static void validatePositive(
    BigDecimal value,
    Supplier<RuntimeException> nullSupplier,
    Supplier<RuntimeException> nonPositiveSupplier
  ) {
    validateSupplier(nullSupplier, "nullSupplier");
    validateSupplier(nonPositiveSupplier, "nonPositiveSupplier");

    if(value == null) throw nullSupplier.get();

    boolean nonPositiveResult = value.compareTo(BigDecimal.ZERO) <= 0;
    if(nonPositiveResult) throw nonPositiveSupplier.get();
  }

  public static void validatePositiveOrZero(
    BigDecimal amount,
    Supplier<RuntimeException> nullSupplier,
    Supplier<RuntimeException> underZeroSupplier
  ) {
    validateSupplier(nullSupplier, "nullSupplier");
    validateSupplier(underZeroSupplier, "underZeroSupplier");

    if(amount == null) throw nullSupplier.get();

    boolean underZeroResult = amount.compareTo(BigDecimal.ZERO) < 0;
    if(underZeroResult) throw underZeroSupplier.get();
  }

  public static void validateMap(
    Map<?, ?> map,
    Supplier<RuntimeException> nullSupplier,
    Supplier<RuntimeException> emptySupplier
  ) {
    validateSupplier(nullSupplier, "nullSupplier");
    validateSupplier(emptySupplier, "emptySupplier");
    
    if(map == null) throw nullSupplier.get();
    if(map.isEmpty()) throw emptySupplier.get();
  }

  public static void validateList(
    List<?> list,
    Supplier<RuntimeException> nullSupplier,
    Supplier<RuntimeException> emptySupplier
  ) {
    validateSupplier(nullSupplier, "nullSupplier");
    validateSupplier(emptySupplier, "emptySupplier");

    if(list == null) throw nullSupplier.get();
    if(list.isEmpty()) throw emptySupplier.get();
  }

  public static void validateEmail(
    String email, 
    Supplier<RuntimeException> nullSupplier,
    Supplier<RuntimeException> invalidEmailSupplier
  ) {
    validateSupplier(nullSupplier, "nullSupplier");
    validateSupplier(invalidEmailSupplier, "invalidEmailSupplier");

    if(email == null) throw nullSupplier.get();

    boolean invalidEmail = !EMAIL_PATTERN.matcher(email).matches();
    if(invalidEmail) throw invalidEmailSupplier.get();
  }

  public static void validatePassword(
    String password, 
    Supplier<RuntimeException> nullSupplier,
    Supplier<RuntimeException> blankSupplier, 
    Supplier<RuntimeException> invalidPasswordSupplier
  ) {
    validateSupplier(nullSupplier, "nullSupplier");
    validateSupplier(blankSupplier, "blankSupplier");
    validateSupplier(invalidPasswordSupplier, "invalidPasswordSupplier");

    if(password == null) throw nullSupplier.get();
    if(password.isBlank()) throw blankSupplier.get();
    if(password.length() < 8) throw invalidPasswordSupplier.get();
  }

  public static void validateEncodedPassword(
    String encoded, 
    Supplier<RuntimeException> nullSupplier,
    Supplier<RuntimeException> blankSupplier,
    Supplier<RuntimeException> invalidPasswordSupplier
  ) {
    validateSupplier(nullSupplier, "nullSupplier");
    validateSupplier(blankSupplier, "blankSupplier");
    validateSupplier(invalidPasswordSupplier, "invalidPasswordSupplier");

    if(encoded == null) throw nullSupplier.get();
    if(encoded.isBlank()) throw blankSupplier.get();

    boolean invalidPassword = 
      !encoded.startsWith("$2a$") && 
      !encoded.startsWith("$2b$") &&
      !encoded.startsWith("$2y$");

    if(invalidPassword) throw invalidPasswordSupplier.get();
  }

  public static void validateAgeSixteen(
    LocalDate birthday,
    Supplier<RuntimeException> nullSupplier,
    Supplier<RuntimeException> underSixteenSupplier
  ) {
    validateSupplier(nullSupplier, "nullSupplier");
    validateSupplier(underSixteenSupplier, "underSixteenSupplier");

    if(birthday == null) throw nullSupplier.get();

    LocalDate minimumBirthday = LocalDate.now().minusYears(16);
    if(birthday.isAfter(minimumBirthday)) throw underSixteenSupplier.get();
  }

  public static void validateSameUnitOfMeasure(
    UnitOfMeasure current, 
    UnitOfMeasure received, 
    Supplier<RuntimeException> nullCurrentUnitOfMeasureSupplier, 
    Supplier<RuntimeException> nullReceivedUnitOfMeasureSupplier,
    Supplier<RuntimeException> differentUnitOfMeasureSupplier
  ) {
    validateSupplier(nullCurrentUnitOfMeasureSupplier, "nullCurrentUnitOfMeasureSupplier");
    validateSupplier(nullReceivedUnitOfMeasureSupplier, "nullReceivedUnitOfMeasureSupplier");
    validateSupplier(differentUnitOfMeasureSupplier, "differentUnitOfMeasureSupplier");

    if(current == null) throw nullCurrentUnitOfMeasureSupplier.get();
    if(received == null) throw nullReceivedUnitOfMeasureSupplier.get();

    boolean differentUnitOfMeasure = current != received;
		if(differentUnitOfMeasure) throw differentUnitOfMeasureSupplier.get();
  }

  public static void validateUnderZeroResult(
    BigDecimal current, 
    BigDecimal received, 
    Supplier<RuntimeException> nullCurrentValueSupplier, 
    Supplier<RuntimeException> nullReceivedValueSupplier, 
    Supplier<RuntimeException> insufficientResultSupplier
  ) {
    validateSupplier(nullCurrentValueSupplier, "nullCurrentValueSupplier");
    validateSupplier(nullReceivedValueSupplier, "nullReceivedValueSupplier");
    validateSupplier(insufficientResultSupplier, "insufficientResultSupplier");

    if(current == null) throw nullCurrentValueSupplier.get();
    if(received == null) throw nullReceivedValueSupplier.get();
    
    boolean insufficientAmount = received.compareTo(current) > 0;
    if(insufficientAmount) throw insufficientResultSupplier.get();
  }

  public static void validateExistenceById(
    Boolean existsById,
    Supplier<RuntimeException> nullSupplier, 
    Supplier<RuntimeException> notFoundSupplier
  ) {
    validateSupplier(nullSupplier, "nullSupplier");
    validateSupplier(notFoundSupplier, "notFoundSupplier");

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
    validateSupplier(nullFirstLongSupplier, "nullFirstLongSupplier");
    validateSupplier(nullSecondLongSupplier, "nullSecondLongSupplier");
    validateSupplier(differentLongSupplier, "differentLongSupplier");

    if(firstLong == null) throw nullFirstLongSupplier.get();
    if(secondLong == null) throw nullSecondLongSupplier.get();
    if(!firstLong.equals(secondLong)) throw differentLongSupplier.get();
  }

  public static void validateInstant(
    Instant instant, 
    Supplier<RuntimeException> nullSupplier, 
    Supplier<RuntimeException> invalidInstantSupplier 
  ) {
    validateSupplier(nullSupplier, "nullSupplier");
    validateSupplier(invalidInstantSupplier, "invalidInstantSupplier");

    if(instant == null) throw nullSupplier.get();
    if(instant.isBefore(Instant.EPOCH)) throw invalidInstantSupplier.get();
  }
}