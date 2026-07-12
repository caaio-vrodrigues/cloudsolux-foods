package com.cloudsolux.foods.global_services.util;

import java.math.BigDecimal;

import com.cloudsolux.foods.global_services.model.UnitOfMeasure;

public class GlobalMsgCreator {
  
  private GlobalMsgCreator() {}

  public static String nullFieldValueMsg(String className, String fieldName) {
    return "Falha ao processar '"+className+"'. Valor 'null' para o campo: ['"+fieldName+"'].";
  }

  public static String nullArgumentMsg(String className, String argument) {
    return "Falha ao processar '"+className+"'. Valor 'null' para o argumento: ['"+argument+"'].";
  }

  public static String positiveMsg(String className, String fieldName, BigDecimal amount) {
    return "Falha ao processar '"+className+"'. Valor igual ou menor que '0' para o campo ['"+fieldName+"': '"+amount+"'].";
  }

  public static String positiveOrZeroMsg(String className, String fieldName, BigDecimal amount) {
    return "Falha ao processar '"+className+"'. Valor menor que '0' para o campo ['"+fieldName+"': '"+amount+"'].";
  }

  public static String invalidUnitOfMeasureMsg(
    String className, UnitOfMeasure incomingUnitOfMeasure, UnitOfMeasure currentUnitOfMeasure2
  ) {
    return "Falha ao processar '"+className+"' por tipo de medida inválido. Valor recebido: ['"+incomingUnitOfMeasure+"']. Valor esperado: ['"+currentUnitOfMeasure2+"'].";
  }

  public static String insuficcientAmount(String className, BigDecimal requiredAmount, BigDecimal currentAmount) {
    return "Falha ao processar '"+className+"' por quantidade em estoque insuficiente. Quantidade solicitada: ['"+requiredAmount+"']. Quantidade disponível: ['"+currentAmount+"'].";
  }

  public static String emptyFieldValue(String className, String fieldName) {
    return "Falha ao processar '"+className+"'. Valor 'vazio' para o campo: ['"+fieldName+"'].";
  }
}
