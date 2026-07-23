package com.cloudsolux.foods.global_services.domain.id_control;

import java.math.BigDecimal;
import java.util.Objects;

import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.global_services.domain.id_control.exception.IdControlInvalidArgumentException;
import com.cloudsolux.foods.global_services.domain.id_control.model.IdControlKey;

public final class IdControl {

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
      if(!(key instanceof IdControlKey)) {
				String receivedClassName = key != null ? 
					key.getClass().getSimpleName() : "null";
				throw new IdControlInvalidArgumentException(GlobalMsgCreator
        	.invalidClassMsg("IdControlKey", receivedClassName));
			}
      this.key = key;
      return this;
    }

    public IdControlBuilder nextValue(Long nextValue) {
      if(!(nextValue instanceof Long)) {
				String receivedClassName = nextValue != null ? 
					nextValue.getClass().getSimpleName() : "null";
				throw new IdControlInvalidArgumentException(GlobalMsgCreator
        	.invalidClassMsg("Long", receivedClassName));
			}
      if(nextValue < 1) {
        throw new IdControlInvalidArgumentException(GlobalMsgCreator
          .positiveMsg("IdControl", "nextValue", BigDecimal.valueOf(nextValue)));
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

  public int hashCode() {
    return Objects.hash(key, nextValue);
  }

  public boolean equals(Object o) {
    if(this == o) return true;
		if(!(o instanceof IdControl other)) return false;
		return Objects.equals(key, other.key) &&
      Objects.equals(nextValue, other.nextValue);
  }

  public String toString() {
    return "IdControl: [key="+key+", nextValue="+nextValue+"].";
  }
}