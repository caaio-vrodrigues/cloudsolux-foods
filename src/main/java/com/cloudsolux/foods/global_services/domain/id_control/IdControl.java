package com.cloudsolux.foods.global_services.domain.id_control;

import java.math.BigDecimal;

import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.global_services.domain.id_control.exception.IdControlInvalidArgumentException;
import com.cloudsolux.foods.global_services.domain.id_control.model.IdControlKey;

public class IdControl {

  private final IdControlKey key;
  private Long nextValue;

  private IdControl(IdControlBuilder builder) {
    this.key = builder.key;
    this.nextValue = builder.nextValue;
  }

  public static class IdControlBuilder {
    private IdControlKey key;
    private Long nextValue;

    public IdControlBuilder key(IdControlKey key) {
      if(key == null) {
        throw new IdControlInvalidArgumentException(GlobalMsgCreator
          .nullArgumentMsg("IdControlEntity", "IdControlKey"));
      }
      this.key = key;
      return this;
    }

    public IdControlBuilder nextValue(Long nextValue) {
      if(nextValue == null) {
        throw new IdControlInvalidArgumentException(GlobalMsgCreator
          .nullArgumentMsg("IdControlEntity", "nextValue"));
      }
      if(nextValue < 1) {
        throw new IdControlInvalidArgumentException(GlobalMsgCreator
          .positiveMsg(
            "null", 
            "nextValue", 
            BigDecimal.valueOf(nextValue)));
      }
      this.nextValue = nextValue;
      return this;
    }

    public IdControl build() {
      if(key == null) {
        throw new IdControlInvalidArgumentException(GlobalMsgCreator
          .nullArgumentMsg("IdControlEntity", "IdControlKey"));
      }
      if(nextValue == null) {
        throw new IdControlInvalidArgumentException(GlobalMsgCreator
          .nullArgumentMsg("IdControlEntity", "nextValue"));
      }
      return new IdControl(this);
    }
  }

  public static IdControlBuilder builder() {
    return new IdControlBuilder();
  }

  public void increment() {
		nextValue++;
	}

  public IdControlKey getKey() {
    return key;
  }

  public Long getNextValue() {
    return nextValue;
  }
}