package com.cloudsolux.foods.global_services.api.global.handler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.context.MessageSourceResolvable;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.global_services.domain.global.util.GlobalValidationAux;

import lombok.extern.slf4j.Slf4j;

@Order(2)
@Slf4j
@RestControllerAdvice
public final class ArgumentExceptionHandler {
	
	private ProblemDetail setProperties(
		ProblemDetail problemDetail, String traceId, List<String> errorList
	) {
		problemDetail.setProperty(GlobalMsgCreator.TIME_STAMP, LocalDateTime.now());
		problemDetail.setProperty(GlobalMsgCreator.TRACE_ID, traceId);
		problemDetail.setProperty(GlobalMsgCreator.ERRORS, errorList);
		return problemDetail;
	}

	private String getFieldErrorMsg(
		String constraint, String fieldName, String defaultMsg
	) {
		String msg = switch(constraint) {
			case GlobalMsgCreator.NOT_BLANK -> GlobalMsgCreator.NOT_BLANK_MSG;
			case GlobalMsgCreator.NOT_NULL -> GlobalMsgCreator.NOT_NULL_MSG;
			case GlobalMsgCreator.NOT_EMPTY -> GlobalMsgCreator.NOT_EMPTY_MSG;
			case GlobalMsgCreator.POSITIVE -> GlobalMsgCreator.POSITIVE_MSG;
			case GlobalMsgCreator.POSITIVE_OR_ZERO -> GlobalMsgCreator.POSITIVE_OR_ZERO_MSG;
			case GlobalMsgCreator.EMAIL -> GlobalMsgCreator.EMAIL_MSG;
			case GlobalMsgCreator.SIZE -> GlobalMsgCreator.SIZE_MSG;
			default -> defaultMsg;
		};

		return GlobalMsgCreator.errorFieldMsg(fieldName, msg);
	}
	
	private List<String> getFieldErrorList(List<FieldError> fieldErrors) {
		return fieldErrors.stream()
			.map(error -> getFieldErrorMsg(
				error.getCode(), error.getField(), error.getDefaultMessage()
			))
			.toList();
	}

	private List<String> getFieldErrorList(HandlerMethodValidationException e) {
		return e.getAllValidationResults().stream()
			.flatMap(error -> error.getResolvableErrors().stream())
			.map(error -> {
				String field = extractFieldName(error);
				String constraint = getConstraintCode(error);
 				return getFieldErrorMsg(constraint, field, error.getDefaultMessage());
			})
			.toList();
	}

	private String extractFieldName(MessageSourceResolvable error) {
    String[] codes = error.getCodes();

    if(codes != null && codes.length > 0) {
			String code = codes[0];
			int lastDot = code.lastIndexOf('.');

			if(lastDot >= 0 && lastDot < code.length() - 1) 
				return code.substring(lastDot + 1);
    }
		
    return "";
	}

	private String getConstraintCode(MessageSourceResolvable error) {
    String[] codes = error.getCodes();

    if(codes != null && codes.length > 0) {
			String code = codes[0];
			int firstDot = code.indexOf('.');

			if(firstDot > 0) 
				return code.substring(0, firstDot);

			return code;
    }

    return "";
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ProblemDetail handleMethodArgumentNotValidException(
		MethodArgumentNotValidException e
	) {
		GlobalValidationAux.validateArgument(e, "MethodArgumentNotValidException");

		String traceId = UUID.randomUUID().toString();

		List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
		List<String> errorList = getFieldErrorList(fieldErrors);

		ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
		problemDetail.setTitle(GlobalMsgCreator.INVALID_ARGUMENT_TITLE);	

		log.error("traceId={} fieldErrors={}", traceId, fieldErrors);
		return setProperties(problemDetail, traceId, errorList);
	}

	@ExceptionHandler(HandlerMethodValidationException.class)
	public ProblemDetail handleHandlerMethodValidationException(
		HandlerMethodValidationException e
	) {
    GlobalValidationAux.validateArgument(e, "HandlerMethodValidationException");

    String traceId = UUID.randomUUID().toString();

		List<String> errorList = getFieldErrorList(e);

    ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
    problemDetail.setTitle(GlobalMsgCreator.INVALID_ARGUMENT_TITLE);

    log.error("traceId={} validationResults={}", traceId, e.getAllValidationResults());
    return setProperties(problemDetail, traceId, errorList);
	}
}