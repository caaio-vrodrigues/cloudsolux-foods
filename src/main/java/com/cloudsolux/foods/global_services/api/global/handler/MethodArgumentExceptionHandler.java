package com.cloudsolux.foods.global_services.api.global.handler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.global_services.domain.global.util.GlobalValidationAux;

import lombok.extern.slf4j.Slf4j;

@Order(2)
@Slf4j
@RestControllerAdvice
public final class MethodArgumentExceptionHandler {
	
	private ProblemDetail setProperties(
		ProblemDetail problemDetail, String traceId, List<String> errorList
	) {
		GlobalValidationAux.validateArgument(problemDetail, "ProblemDetail");
		GlobalValidationAux.validateString(traceId, traceId);
		GlobalValidationAux.validateArgument(errorList, "List<String>");
		
		problemDetail.setProperty(GlobalMsgCreator.TIME_STAMP, LocalDateTime.now());
		problemDetail.setProperty(GlobalMsgCreator.TRACE_ID, traceId);
		problemDetail.setProperty(GlobalMsgCreator.ERRORS, errorList);
		return problemDetail;
	}
	
	private List<String> getBindingResultList(List<FieldError> fieldErrors) {
		GlobalValidationAux.validateArgument(fieldErrors, "List<FieldError>");

		return fieldErrors.stream().map(error -> {
			GlobalValidationAux.validateArgument(error, "FieldError");

			String msg = switch(error.getCode()) {
				case GlobalMsgCreator.NOT_BLANK -> GlobalMsgCreator.NOT_BLANK_MSG;
				case GlobalMsgCreator.NOT_NULL -> GlobalMsgCreator.NOT_NULL_MSG;
				case GlobalMsgCreator.NOT_EMPTY -> GlobalMsgCreator.NOT_EMPTY_MSG;
				case GlobalMsgCreator.POSITIVE -> GlobalMsgCreator.POSITIVE_MSG;
				case GlobalMsgCreator.POSITIVE_OR_ZERO -> GlobalMsgCreator.POSITIVE_OR_ZERO_MSG;
				case GlobalMsgCreator.ASSERT_FALSE -> error.getDefaultMessage();
				default -> error.getDefaultMessage();
			};

			return error.getCode().equals("NotEmpty") ?
				GlobalMsgCreator.errorListMsg(error.getField(), msg) 
				: GlobalMsgCreator.errorFieldMsg(error.getField(), msg);
		})
		.toList();
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ProblemDetail handleMethodArgumentNotValidException(
		MethodArgumentNotValidException e
	) {
		GlobalValidationAux.validateArgument(e, "MethodArgumentNotValidException");

		String traceId = UUID.randomUUID().toString();

		List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
		List<String> errorList = getBindingResultList(fieldErrors);

		ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
		problemDetail.setTitle(GlobalMsgCreator.INVALID_ARGUMENT_TITLE);	

		log.error("traceId={} fieldErrors={}", traceId, fieldErrors);
		return setProperties(problemDetail, traceId, errorList);
	}
}