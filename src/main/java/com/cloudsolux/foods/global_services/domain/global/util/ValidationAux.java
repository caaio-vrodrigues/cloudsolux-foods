package com.cloudsolux.foods.global_services.domain.global.util;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import com.cloudsolux.foods.global_services.domain.global.exception.GlobalInvalidArgumentException;
import com.cloudsolux.foods.global_services.domain.global.model.UnitOfMeasure;

public final class ValidationAux {

  private ValidationAux() {}

  public static void validateNull(
    Object argument, 
    Supplier<RuntimeException> nullSupplier
  ) {
    if(nullSupplier == null) throw new GlobalInvalidArgumentException(GlobalMsgCreator
      .nullArgumentMsg("Global", "nullSupplier"));

    if(argument == null) throw nullSupplier.get();
  }

  public static void validateString(
    String value,
    Supplier<RuntimeException> nullSupplier,
    Supplier<RuntimeException> blankSupplier
  ) {
    if(nullSupplier == null) throw new GlobalInvalidArgumentException(GlobalMsgCreator
      .nullArgumentMsg("Global", "nullSupplier"));

    if(blankSupplier == null) throw new GlobalInvalidArgumentException(GlobalMsgCreator
      .nullArgumentMsg("Global", "blankSupplier"));

    if(value == null) throw nullSupplier.get();
    if(value.isBlank()) throw blankSupplier.get();
  }

  public static void validatePositive(
    Long value,
    Supplier<RuntimeException> nullSupplier,
    Supplier<RuntimeException> nonPositiveSupplier
  ) {
    if(nullSupplier == null) throw new GlobalInvalidArgumentException(GlobalMsgCreator
      .nullArgumentMsg("Global", "nullSupplier"));

    if(nonPositiveSupplier == null) throw new GlobalInvalidArgumentException(GlobalMsgCreator
      .nullArgumentMsg("Global", "nonPositiveSupplier"));

    if(value == null) throw nullSupplier.get();
    if(value < 1) throw nonPositiveSupplier.get();
  }

  public static void validatePositive(
    BigDecimal value,
    Supplier<RuntimeException> nullSupplier,
    Supplier<RuntimeException> nonPositiveSupplier
  ) {
    if(nullSupplier == null) throw new GlobalInvalidArgumentException(GlobalMsgCreator
      .nullArgumentMsg("Global", "nullSupplier"));

    if(nonPositiveSupplier == null) throw new GlobalInvalidArgumentException(GlobalMsgCreator
      .nullArgumentMsg("Global", "nonPositiveSupplier"));

    if(value == null) throw nullSupplier.get();

    boolean nonPositiveResult = value.compareTo(BigDecimal.ZERO) < 1;
    if(nonPositiveResult) throw nonPositiveSupplier.get();
  }

  public static void validatePositiveOrZero(
    BigDecimal amount,
    Supplier<RuntimeException> nullSupplier,
    Supplier<RuntimeException> underZeroSupplier
  ) {
    if(nullSupplier == null) throw new GlobalInvalidArgumentException(GlobalMsgCreator
      .nullArgumentMsg("Global", "nullSupplier"));

    if(underZeroSupplier == null) throw new GlobalInvalidArgumentException(GlobalMsgCreator
      .nullArgumentMsg("Global", "underZeroSupplier"));

    if(amount == null) throw nullSupplier.get();

    boolean underZeroResult = amount.compareTo(BigDecimal.ZERO) < 0;
    if(underZeroResult) throw underZeroSupplier.get();
  }

  public static void validateMap(
    Map<?, ?> map,
    Supplier<RuntimeException> nullSupplier,
    Supplier<RuntimeException> emptySupplier
  ) {
    if(nullSupplier == null) throw new GlobalInvalidArgumentException(GlobalMsgCreator
      .nullArgumentMsg("Global", "nullSupplier"));

    if(emptySupplier == null) throw new GlobalInvalidArgumentException(GlobalMsgCreator
      .nullArgumentMsg("Global", "emptySupplier"));
    
    if(map == null) throw nullSupplier.get();
    if(map.isEmpty()) throw emptySupplier.get();
  }

  public static void validateList(
    List<?> list,
    Supplier<RuntimeException> nullSupplier,
    Supplier<RuntimeException> nullElementSupplier,
    Supplier<RuntimeException> emptySupplier
  ) {
    if(nullSupplier == null) throw new GlobalInvalidArgumentException(GlobalMsgCreator
      .nullArgumentMsg("Global", "nullSupplier"));

    if(nullElementSupplier == null) throw new GlobalInvalidArgumentException(GlobalMsgCreator
      .nullArgumentMsg("Global", "nullElementSupplier"));

    if(emptySupplier == null) throw new GlobalInvalidArgumentException(GlobalMsgCreator
      .nullArgumentMsg("Global", "emptySupplier"));

    if(list == null) throw nullSupplier.get();
    if(list.contains(null)) throw nullElementSupplier.get();
    if(list.isEmpty()) throw emptySupplier.get();
  }

  public static void validateEmail(
    String email, 
    Supplier<RuntimeException> nullSupplier,
    Supplier<RuntimeException> invalidEmailSupplier
  ) {
    if(nullSupplier == null) throw new GlobalInvalidArgumentException(GlobalMsgCreator
      .nullArgumentMsg("Global", "nullSupplier"));

    if(invalidEmailSupplier == null) throw new GlobalInvalidArgumentException(GlobalMsgCreator
      .nullArgumentMsg("Global", "invalidEmailSupplier"));

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
    if(nullSupplier == null) throw new GlobalInvalidArgumentException(GlobalMsgCreator
      .nullArgumentMsg("Global", "nullSupplier"));

    if(blankSupplier == null) throw new GlobalInvalidArgumentException(GlobalMsgCreator
      .nullArgumentMsg("Global", "blankSupplier"));

    if(invalidPasswordSupplier == null) throw new GlobalInvalidArgumentException(GlobalMsgCreator
      .nullArgumentMsg("Global", "invalidPasswordSupplier"));

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
    if(nullSupplier == null) throw new GlobalInvalidArgumentException(GlobalMsgCreator
      .nullArgumentMsg("Global", "nullSupplier"));

    if(underSixteenSupplier == null) throw new GlobalInvalidArgumentException(GlobalMsgCreator
      .nullArgumentMsg("Global", "underSixteenSupplier"));

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
    if(nullCurrentUnitOfMeasureSupplier == null) throw new GlobalInvalidArgumentException(GlobalMsgCreator
      .nullArgumentMsg("Global", "nullCurrentUnitOfMeasureSupplier"));

    if(nullReceivedUnitOfMeasureSupplier == null) throw new GlobalInvalidArgumentException(GlobalMsgCreator
      .nullArgumentMsg("Global", "nullReceivedUnitOfMeasureSupplier"));

    if(differentUnitOfMeasureSupplier == null) throw new GlobalInvalidArgumentException(GlobalMsgCreator
      .nullArgumentMsg("Global", "differentUnitOfMeasureSupplier"));

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
    if(nullCurrentValueSupplier == null) throw new GlobalInvalidArgumentException(GlobalMsgCreator
      .nullArgumentMsg("Global", "nullSupplier"));

    if(nullReceivedValueSupplier == null) throw new GlobalInvalidArgumentException(GlobalMsgCreator
      .nullArgumentMsg("Global", "nullSupplier"));
      
    if(insufficientResultSupplier == null) throw new GlobalInvalidArgumentException(GlobalMsgCreator
      .nullArgumentMsg("Global", "insufficientResultSupplier"));

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
    if(nullSupplier == null) throw new GlobalInvalidArgumentException(GlobalMsgCreator
      .nullArgumentMsg("Global", "nullSupplier"));

    if(notFoundSupplier == null) throw new GlobalInvalidArgumentException(GlobalMsgCreator
      .nullArgumentMsg("Global", "notFoundSupplier"));

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
    if(nullFirstLongSupplier == null) throw new GlobalInvalidArgumentException(GlobalMsgCreator
      .nullArgumentMsg("Global", "nullFirstLongSupplier"));

    if(nullSecondLongSupplier == null) throw new GlobalInvalidArgumentException(GlobalMsgCreator
      .nullArgumentMsg("Global", "nullSecondLongSupplier"));

    if(differentLongSupplier == null) throw new GlobalInvalidArgumentException(GlobalMsgCreator
      .nullArgumentMsg("Global", "differentLongSupplier"));

    if(firstLong == null) throw nullFirstLongSupplier.get();
    if(secondLong == null) throw nullSecondLongSupplier.get();
    if(!firstLong.equals(secondLong)) throw differentLongSupplier.get();
  }
}