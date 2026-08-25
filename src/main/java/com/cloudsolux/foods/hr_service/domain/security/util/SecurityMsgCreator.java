package com.cloudsolux.foods.hr_service.domain.security.util;

public final class SecurityMsgCreator {
 
  public static final String AUTHENTICATION_SUMMARY = "Autenticar usuário";
  public static final String AUTHENTICATION_DESCRIPTION = "Recebe email e senha, autentica e retorna um token JWT. "
    +"Endpoint público — não exige cabeçalho Authorization.";

  private SecurityMsgCreator() {}

}