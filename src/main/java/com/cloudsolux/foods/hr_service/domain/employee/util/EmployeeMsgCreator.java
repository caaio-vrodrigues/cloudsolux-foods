package com.cloudsolux.foods.hr_service.domain.employee.util;

public final class EmployeeMsgCreator {
  
  public static final String NEW_EMPLOYEE_SUMMARY = "Registra novo colaborador no sistema de recursos-humanos." +
    " O campo ['email'] deve ser único.";

  public static final String NEW_EMPLOYEE_DESCRIPTION = "Cadastrar novo colaborador.";

  private EmployeeMsgCreator() {}

  public static String uniquenessViolationMsg(String email) {
    return "Falha ao processar 'Employee'. O 'email' fornecido para criação do colaborador já está em uso: ['email="+email+"'].";
  }
}