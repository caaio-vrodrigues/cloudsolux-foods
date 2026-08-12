package com.cloudsolux.foods.hr_service.domain.user_account.util;

public final class UserAccountMsgCreator {
  
  private UserAccountMsgCreator() {}

  public static String uniquenessViolationMsg(String email) {
    return "Falha ao processar 'UserAccount'. O 'email' fornecido para criação do usuário já está em uso: ['email="+email+"'].";
  }
}