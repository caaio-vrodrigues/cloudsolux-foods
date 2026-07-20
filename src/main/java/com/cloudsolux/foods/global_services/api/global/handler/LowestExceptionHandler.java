package com.cloudsolux.foods.global_services.api.global.handler;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Order(4)
@RestControllerAdvice
public class LowestExceptionHandler {

  private ProblemDetail setProperties(
		ProblemDetail problemDetail, String traceId
	) {
		problemDetail.setProperty(GlobalMsgCreator.TIME_STAMP, LocalDateTime.now());
		problemDetail.setProperty(GlobalMsgCreator.TRACE_ID, traceId);
		return problemDetail;
	}
		
	private ProblemDetail createProblemDetailAndLog(
		RuntimeException e, HttpStatus status, String title
	) {
		String traceId = UUID.randomUUID().toString();
		ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
			status, 
			GlobalMsgCreator.INTERNAL_FAILURE_MSG
		);
		problemDetail.setTitle(title);
		log.error("traceId={} error={}", traceId, e.getMessage(), e);
		return setProperties(problemDetail, traceId);
	}

	@ExceptionHandler(RuntimeException.class)
	public ProblemDetail handleRuntimeException(RuntimeException e) {
		return createProblemDetailAndLog(
			e, 
			HttpStatus.INTERNAL_SERVER_ERROR, 
			GlobalMsgCreator.UNEXPECTED_FAILURE_TITLE
		);
	}
}