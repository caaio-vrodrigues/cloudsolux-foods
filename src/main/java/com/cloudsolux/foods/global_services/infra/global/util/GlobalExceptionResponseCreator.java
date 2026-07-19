package com.cloudsolux.foods.global_services.infra.global.util;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GlobalExceptionResponseCreator {
  
  private GlobalExceptionResponseCreator() {}
	
	private static ProblemDetail setProperties(
		ProblemDetail problemDetail, String traceId
	) {
		problemDetail.setProperty("timestamp", LocalDateTime.now());
		problemDetail.setProperty("traceId", traceId);
		return problemDetail;
	}
		
	public static ProblemDetail createProblemDetailAndLog(
		RuntimeException e, HttpStatus status, String title
	) {
		String traceId = UUID.randomUUID().toString();
		ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
			status, e.getMessage()
		);
		problemDetail.setTitle(title);
		log.error("traceId={} - ERROR:", traceId, e);
		return setProperties(problemDetail, traceId);
	}
}