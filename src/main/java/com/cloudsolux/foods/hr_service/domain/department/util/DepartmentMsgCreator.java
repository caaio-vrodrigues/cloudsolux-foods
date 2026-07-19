package com.cloudsolux.foods.hr_service.domain.department.util;

public class DepartmentMsgCreator {
  
  private DepartmentMsgCreator() {}

  public static String uniquenessViolationMsg(String name) {
    return "Falha ao processar 'DepartmentEntity'. O argumento 'name' fornecido para criação do departamento já está em uso: [name: '"+name+"'].";
  }
}