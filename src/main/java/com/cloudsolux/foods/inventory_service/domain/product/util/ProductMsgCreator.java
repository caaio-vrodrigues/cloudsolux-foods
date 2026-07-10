package com.cloudsolux.foods.inventory_service.domain.product.util;

public class ProductMsgCreator {
  
  public static final String NEW_PRODUCT_DESCRIPTION = "Registra um novo produto no sistema de catálogo e inventário." +
    " A combinação dos campos ['name', 'model' e 'brand'] deve ser única.";
    
  public static final String NEW_PRODUCT_SUMMARY = "Cadastrar novo produto";

  public static final String RESPONSE_201 = "Produto cadastrado com sucesso";
  public static final String RESPONSE_400 = "Dados inválidos — violação de regras de negócio ou requisição inválida";
  public static final String RESPONSE_409 = "Conflito — violação de regras de negócio";

  private ProductMsgCreator() {}
}