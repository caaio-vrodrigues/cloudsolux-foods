package com.cloudsolux.foods.global_services.domain.id_control;

import java.util.Objects;

import com.cloudsolux.foods.global_services.domain.id_control.model.IdControlKey;
import com.cloudsolux.foods.global_services.domain.id_control.util.IdControlValidationAux;

public final class IdControl {

  private final IdControlKey key;
  private Long nextValue;

  private IdControl(IdControlBuilder builder) {
    IdControlValidationAux.validateArgument(builder.key, "IdControlKey");
    IdControlValidationAux.validatePositiveLong(builder.nextValue, "nextValue");
    key = builder.key;
    nextValue = builder.nextValue;
  }

  public static class IdControlBuilder {
    private IdControlKey key;
    private Long nextValue;

    public IdControlBuilder key(IdControlKey key) {
      this.key = key;
      return this;
    }

    public IdControlBuilder nextValue(Long nextValue) {
      this.nextValue = nextValue;
      return this;
    }

    public IdControl build() {
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

  @Override
  public int hashCode() {
    return Objects.hash(key);
  }

  @Override
  public boolean equals(Object o) {
    if(this == o) return true;
		if(!(o instanceof IdControl other)) return false;
		return Objects.equals(key, other.key);
  }

  @Override
  public String toString() {
    return "IdControl: ['key="+key+"', 'nextValue="+nextValue+"']";
  }
}