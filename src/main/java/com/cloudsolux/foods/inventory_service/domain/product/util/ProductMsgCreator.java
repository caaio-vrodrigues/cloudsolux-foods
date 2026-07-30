package com.cloudsolux.foods.inventory_service.domain.product.util;

public final class ProductMsgCreator {
  
  public static final String NEW_PRODUCT_DESCRIPTION = "Registra um novo produto no sistema de catálogo e inventário." +
    " A combinação dos campos ['name', 'model' e 'brand'] deve ser única.";
    
  public static final String NEW_PRODUCT_SUMMARY = "Cadastrar novo produto";

  private ProductMsgCreator() {}

  public static String uniquenessViolationMsg(String name, String model, String brand) {
    return "Falha ao processar 'Product'. Os argumentos fornecidos para criação do produto já estão em uso: [name="+name+"', model='"+model+"', brand='"+brand+"'].";
  }

  public static String unrelatedDomainsOnResponseCreation(Long productId, Long catalogId) {
    return "Falha ao processar 'Product'. Os domínios fornecidos para criação do DTO de resposta não possuem o mesmo 'id'. [Product: 'id="+productId+"'], [Inventory: 'catalogId="+catalogId+"'].";
  }
}