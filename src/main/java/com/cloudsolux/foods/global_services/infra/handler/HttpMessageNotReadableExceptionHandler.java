package com.cloudsolux.foods.global_services.infra.handler;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cloudsolux.foods.global_services.util.GlobalMsgCreator;
import com.fasterxml.jackson.databind.exc.InvalidTypeIdException;

import lombok.extern.slf4j.Slf4j;

@Order(2)
@Slf4j
@RestControllerAdvice
public class HttpMessageNotReadableExceptionHandler {

	private ProblemDetail setProperties(
		ProblemDetail problemDetail, String traceId
	) {
		problemDetail.setProperty(
			GlobalMsgCreator.TIME_STAMP, 
			LocalDateTime.now()
		);
		problemDetail.setProperty(
			GlobalMsgCreator.TRACE_ID, 
			traceId
		);
		return problemDetail;
	}

	private ProblemDetail createProblemDetailAndLog(
		RuntimeException e, HttpStatus status, String title, String detail
	) {
		String traceId = UUID.randomUUID().toString();
		ProblemDetail problemDetail = ProblemDetail
			.forStatusAndDetail(status, detail);
		problemDetail.setTitle(title);
		log.error("traceId={} error={}", traceId, e.getMessage(), e);
		return setProperties(problemDetail, traceId);
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ProblemDetail handleHttpMessageNotReadableException(
		HttpMessageNotReadableException e
	) {
		Throwable cause = e.getMostSpecificCause();	
		if(cause instanceof InvalidTypeIdException) {
			return createProblemDetailAndLog(
				e, 
				HttpStatus.BAD_REQUEST, 
				GlobalMsgCreator.INVALID_TYPE_TITLE, 
				GlobalMsgCreator.INVALID_TYPE_MSG
			);
		}	
		return createProblemDetailAndLog(
			e, 
			HttpStatus.BAD_REQUEST, 
			GlobalMsgCreator.INVALID_JSON_FORMAT_TITLE, 
			GlobalMsgCreator.INVALID_JSON_FORMAT_MSG
		);
	}
}