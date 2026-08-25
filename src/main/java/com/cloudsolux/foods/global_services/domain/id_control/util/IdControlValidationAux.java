package com.cloudsolux.foods.global_services.domain.id_control.util;

import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.global_services.domain.global.util.ValidationAux;
import com.cloudsolux.foods.global_services.domain.id_control.exception.IdControlInvalidArgumentException;
import com.cloudsolux.foods.global_services.domain.id_control.model.IdControlKey;

public final class IdControlValidationAux {
  
  private IdControlValidationAux() {}

  public static void validateArgument(Object argument, String argumentType) {
    ValidationAux.validateNull(
      argument, 
      () -> new IdControlInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("IdControl", argumentType))
    );
  }

  public static void validatePositive(Long value, String argumentName) {
    ValidationAux.validatePositive(
      value, 
      () -> new IdControlInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("IdControl", argumentName)), 
      () -> new IdControlInvalidArgumentException(GlobalMsgCreator
        .positiveMsg("IdControl", argumentName, value))
    );
  }

  public static void validateIdControlKey(
    IdControlKey current, IdControlKey received
  ) {
    if(current == null)
      throw new IdControlInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("IdControl", "current"));

    if(received == null)
      throw new IdControlInvalidArgumentException(GlobalMsgCreator
        .nullArgumentMsg("IdControl", "received"));

    if(!current.equals(received)) 
      throw new IdControlInvalidArgumentException(IdControlMsgCreator
        .unrelatedKeysMsg(current, received));
  }
}