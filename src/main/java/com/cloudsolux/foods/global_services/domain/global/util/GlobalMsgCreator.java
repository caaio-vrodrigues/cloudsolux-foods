package com.cloudsolux.foods.global_services.domain.global.util;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

import com.cloudsolux.foods.global_services.domain.global.model.UnitOfMeasure;

public final class GlobalMsgCreator {

  public static final String RESPONSE_200 = "Operação bem-sucedida";
  public static final String RESPONSE_201 = "Criação concluída com sucesso";
  public static final String RESPONSE_400 = "Dados inválidos — violação de regras de negócio ou requisição inválida";
  public static final String RESPONSE_401 = "Não autorizado — possível falha de autenticação";
  public static final String RESPONSE_409 = "Conflito — violação de regras de negócio";
  public static final String RESPONSE_500 = "Erro interno inesperado";

  public static final String TIME_STAMP = "timestamp";
	public static final String TRACE_ID = "traceId";
	public static final String ERRORS = "errors";
	public static final String ASSERT_FALSE = "AssertFalse";
	public static final String NOT_BLANK = "NotBlank";
	public static final String NOT_NULL = "NotNull";
	public static final String NOT_EMPTY = "NotEmpty";
	public static final String POSITIVE = "Positive";
	public static final String POSITIVE_OR_ZERO = "PositiveOrZero";
  public static final String EMAIL = "Email";
  public static final String SIZE = "Size";
	
	public static final String INTERNAL_FAILURE_MSG = "Falha interna, acione o suporte";
	public static final String NOT_BLANK_MSG = "não pode ser vazio";
	public static final String NOT_NULL_MSG = "não pode ser nulo";
	public static final String NOT_EMPTY_MSG = "não pode ser vazia";
	public static final String POSITIVE_MSG = "deve ser maior que zero";
	public static final String POSITIVE_OR_ZERO_MSG = "deve ser igual ou maior que zero";
	public static final String INVALID_JSON_FORMAT_MSG = "O corpo da requisição não pôde ser interpretado. Verifique a sintaxe JSON e se os tipos dos campos correspondem ao esperado pelo endpoint";
  public static final String INVALID_TYPE_MSG = "O valor fornecido para o discriminador de tipo não corresponde a nenhum tipo conhecido. Consulte a documentação da API para os tipos suportados";
  public static final String EMAIL_MSG = "possui formato inválido";
  public static final String SIZE_MSG = "possui tamanho inválido";
	
	public static final String INVALID_TYPE_TITLE = "Tipo inválido";
	public static final String INVALID_JSON_FORMAT_TITLE = "Corpo da requisição inválido";
	public static final String UNEXPECTED_FAILURE_TITLE = "Falha inesperada";
	public static final String INVALID_ARGUMENT_TITLE = "Argumento inválido";
	public static final String CONCURRENCY_TITLE = "Falha interna";
	public static final String DUPLICATED_ENTITY_TITLE = "Entidade duplicada";
  public static final String ACCESS_FAILURE_TITLE = "Falha de acesso";
  public static final String PERSISTENCE_FAILURE_TITLE = "Falha de persistência";
  public static final String DEPENDENCY_FAILURE_TITLE = "Dependência inválida";
  public static final String NOT_FOUND_TITLE = "Não encontrado";
  public static final String LOGIN_INVALID_CREDENTIALS_TITLE = "Falha ao autenticar credenciais";
  public static final String LOGIN_DISABLED_TITLE = "Desativado";
  
  private GlobalMsgCreator() {}
	
	public static String errorFieldMsg(String field, String msg) {
		return "O campo: ['"+field+"'] "+msg+".";
	}

  public static String nullArgumentMsg(String className, String argumentName) {
    return "Falha ao processar '"+className+"'. Valor 'null' para o argumento: ['"+argumentName+"'].";
  }

  public static String emptyArgumentMsg(String className, String argumentName) {
    return "Falha ao processar '"+className+"'. Valor 'vazio' para o argumento: ['"+argumentName+"'].";
  }

  public static String positiveMsg(String className, String argumentName, BigDecimal value) {
    return "Falha ao processar '"+className+"'. Valor igual ou menor que '0' para o argumento: ['"+argumentName+"': '"+value+"'].";
  }

  public static String positiveMsg(String className, String argumentName, Long value) {
    return "Falha ao processar '"+className+"'. Valor igual ou menor que '0' para o argumento: ['"+argumentName+"': '"+value+"'].";
  }

  public static String positiveOrZeroMsg(String className, String argumentName, BigDecimal amount) {
    return "Falha ao processar '"+className+"'. Valor menor que '0' para o argumento: ['"+argumentName+"': '"+amount+"'].";
  }

  public static String invalidUnitOfMeasureMsg(
    String className, UnitOfMeasure incomingUnitOfMeasure, UnitOfMeasure currentUnitOfMeasure
  ) {
    return "Falha ao processar '"+className+"'. Tipo de medida inválido. Valor recebido: ['"+incomingUnitOfMeasure+"']. Valor esperado: ['"+currentUnitOfMeasure+"'].";
  }

  public static String persistenceFailureLogMsg(String className) {
		return "Falha ao tentar persistir entidade: ['"+className+"'].";
	}

  public static String accessFailureLogMsg(String className) {
		return "Falha ao tentar acessar entidades: ['"+className+"'].";
	}

  public static String persistenceFailureMsg(String className) {
    return "Falha interna desconhecida ao tentar persistir entidade: ['"+className+"'].";
  }

  public static String accessFailureMsg(String className) {
    return "Falha ao acessar os dados. Não foi possível acessar as entidades ['"+className+"']. Verifique o banco de dados e a integridade dos dados retornados.";
  }

  public static String nullDependencyResultMsg(String className, String dependencyName, String dependencyType) {
    return "Falha ao processar '"+className+"'. Resultado nulo retornado por serviço da dependência: ['"+dependencyName+"']. Resultado esperado: ['"+dependencyType+"'], resultado obtido: ['null']";
  }

  public static String emptyDependencyList(String className, String dependencyType) {
    return "Falha ao processar '"+className+"'. Lista de implementações vazia ao acessar dependência: ['"+dependencyType+"'].";
  }

  public static String emptyImplementationList(String className, String implementationsType) {
    return "Falha ao processar '"+className+"'. Lista de implementações vazia para: ['"+implementationsType+"'].";
  }

  public static String invalidEmailFormatMsg(String className, String email, String argumentName) {
    return "Falha ao processar '"+className+"'. E-mail inválido para o argumento: ['"+argumentName+"="+email+"'].";
  }

  public static String notFoundMsg(String className, Long id) {
    return "Não foi possível encontrar '"+className+"' para o id: ['"+id+"'].";
  }

  public static String invalidPasswordOnAccesMsg(String className, String argumentName) {
    return "Falha de Segurança. Senha inválida ao tentar realizar login.";
  }

  public static String invalidPasswordLengthMsg(String className, String argumentName) {
    return "Falha ao processar '"+className+"'. Senha inválida para o argumento: ['"+argumentName+"']. A senha fornecida deve ser maior.";
  }

  public static String invalidPasswordHashMsg(String className, String argumentName) {
    return "Falha ao processar '"+className+"'. Senha inválida para o argumento: ['"+argumentName+"'].";
  }

  public static String minimumAgeSixteenMsg(String className, String argumentName, LocalDate birthday) {
    return "Falha ao processar '"+className+"'. A idade mínima exigida é de '16' anos. Valor recebido: ['"+argumentName+"="+birthday+"'].";
  }

  public static String underZeroResult(String className, String argumentName, BigDecimal requestedAmount, BigDecimal availableAmount) {
    return "Falha ao processar '"+className+"'. Resultado do cálculo menor que '0' para o campo: '["+argumentName+"]'. Valor recebido: ['"+requestedAmount+"']. Valor disponível: ['"+availableAmount+"'].";
  }

  public static String emptyList(String className, String listType) {
    return "Falha ao processar '"+className+"'. Lista de '"+listType+"' vazia.";
  }

  public static String nullListElementMsg(String className, String listType) {
    return "Falha ao processar '"+className+"'. Lista de '"+listType+"' possui elementos 'null'.";
  }

  public static String invalidInstant(String className, String argumentName, Instant purchaseDate) {
    return "Falha ao processar '"+className+"'. Data recebida inválida: ['"+argumentName+"'='"+purchaseDate+"'].";
  }
}