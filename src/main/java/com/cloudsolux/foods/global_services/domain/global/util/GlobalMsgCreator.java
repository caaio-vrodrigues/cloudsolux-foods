package com.cloudsolux.foods.global_services.domain.global.util;

import java.math.BigDecimal;
import java.util.List;

import com.cloudsolux.foods.global_services.domain.global.model.UnitOfMeasure;

public class GlobalMsgCreator {

  public static final String RESPONSE_201 = "Criação concluída com sucesso.";
  public static final String RESPONSE_400 = "Dados inválidos — violação de regras de negócio ou requisição inválida";
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
	
	public static final String INTERNAL_FAILURE_MSG = "Falha interna, acione o suporte.";
	public static final String NOT_BLANK_MSG = "não pode ser vazio";
	public static final String NOT_NULL_MSG = "não pode ser nulo";
	public static final String NOT_EMPTY_MSG = "não pode ser vazia";
	public static final String POSITIVE_MSG = "deve ser maior que zero";
	public static final String POSITIVE_OR_ZERO_MSG = "deve ser igual ou maior que zero";
	public static final String INVALID_JSON_FORMAT_MSG = "O corpo da requisição não pôde ser interpretado. Verifique a sintaxe JSON e se os tipos dos campos correspondem ao esperado pelo endpoint.";
  public static final String INVALID_TYPE_MSG = "O valor fornecido para o discriminador de tipo não corresponde a nenhum tipo conhecido. Consulte a documentação da API para os tipos suportados.";
	
	public static final String INVALID_TYPE_TITLE = "Tipo inválido.";
	public static final String INVALID_JSON_FORMAT_TITLE = "Corpo da requisição inválido.";
	public static final String UNEXPECTED_FAILURE_TITLE = "Falha inesperada";
	public static final String INVALID_ARGUMENT_TITLE = "Argumento inválido";
	public static final String CONCURRENCY_TITLE = "Falha interna";
	public static final String DUPLICATED_ENTITY_TITLE = "Entidade duplicada";
  public static final String ACCESS_FAILURE_TITLE = "Falha de acesso";
  public static final String PERSISTENCE_FAILURE_TITLE = "Falha de persistência";
  public static final String DEPENDENCY_FAILURE_TITLE = "Dependência inválida";
  
  private GlobalMsgCreator() {}

  public static String nullFieldValueMsg(String className, String fieldName) {
    return "Falha ao processar '"+className+"'. Valor 'null' para o campo: ['"+fieldName+"'].";
  }

  public static String nullArgumentMsg(String className, String argument) {
    return "Falha ao processar '"+className+"'. Valor 'null' para o argumento: ['"+argument+"'].";
  }

  public static String nullArgumentMsg(String className, List<String> nullArguments) {
    return "Falha ao processar '"+className+"'. Valor 'null' para os argumentos: ['"+nullArguments+"'].";
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

  public static String persistenceFailureLogMsg(String className) {
		return "Falha ao tentar persistir entidade: '"+className+"'.";
	}

  public static String persistenceFailureMsg(String className) {
    return "Falha interna desconhecida ao tentar persistir entidade: '"+className+"'.";
  }

  public static String errorListMsg(String field, String msg) {
		return "A lista: `"+field+"` "+msg+".";
	}
	
	public static String errorFieldMsg(String field, String msg) {
		return "O campo: `"+field+"` "+msg+".";
	}

  public static String nullDependencyMsg(String interfaceName, String beanName) {
    return "Falha na injeção de: '"+interfaceName+"'. Valor 'null' ao acessar bean: '"+beanName+"'.";
  }

  public static String nullImplementationMsg(String portName) {
    return "Falha nas implementações de: '"+portName+"'. Valor 'null' ao acessar lista de implementações.";
  }

  public static String emptyDependencyList(String interfaceName, String beanName) {
    return "Falha na injeção de: '"+interfaceName+"'. Lista de implementações vazia ao acessar bean: '"+beanName+"'.";
  }

  public static String emptyImplementationList(String portName) {
     return "Falha nas implementações de: '"+portName+"'. Lista de implementações vazia.";
  }

  public static String dataAccessLogMsg(String className) {
    return "Falha ao tentar buscar entidades: '"+className+"'.";
  }

  public static String dataAccesFailureMsg(String className) {
    return "Falha ao acessar os dados. Não foi possível acessar as entidades '"+className+"'. Verifique o banco de dados e a integridade dos dados retornados.";
  }

  public static String invalidClassMsg(String expectedClassName, String receivedClassName) {
    return "Classe inválida durante processo. [esperado: '"+expectedClassName+"'], [recebido: '"+receivedClassName+"'].";
  }
}