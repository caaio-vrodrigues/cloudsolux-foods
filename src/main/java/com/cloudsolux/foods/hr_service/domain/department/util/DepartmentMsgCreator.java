package com.cloudsolux.foods.hr_service.domain.department.util;

public final class DepartmentMsgCreator {
  
  public static final String NEW_DEPARTMENT_SUMMARY = "Registra novo departamento no sistema de recursos-humanos." +
    " O campo ['name'] deve ser único.";
  public static final String NEW_DEPARTMENT_DESCRIPTION = "Cadastrar novo departamento.";

  private DepartmentMsgCreator() {}

  public static String uniquenessViolationMsg(String name) {
    return "Falha ao processar 'Department'. O argumento 'name' fornecido para criação do departamento já está em uso: [name='"+name+"'].";
  }
}