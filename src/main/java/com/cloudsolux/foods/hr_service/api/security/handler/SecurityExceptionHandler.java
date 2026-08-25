package com.cloudsolux.foods.hr_service.api.security.handler;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.global_services.infra.global.util.ExceptionResponseCreator;
import com.cloudsolux.foods.hr_service.domain.security.exception.SecurityInvalidArgumentException;

@Order(2)
@RestControllerAdvice
public final class SecurityExceptionHandler {
 
  @ExceptionHandler(SecurityInvalidArgumentException.class)
  public ProblemDetail handleSecurityInvalidArgument(
    SecurityInvalidArgumentException e
  ) {
    return ExceptionResponseCreator.createProblemDetailAndLog(
      e,
      HttpStatus.BAD_REQUEST,
      GlobalMsgCreator.INVALID_ARGUMENT_TITLE
    );
  }

  @ExceptionHandler(BadCredentialsException.class)
  public ProblemDetail handleBadCredentials(
    BadCredentialsException e
  ) {
    return ExceptionResponseCreator.createProblemDetailAndLog(
      e,
      HttpStatus.UNAUTHORIZED,
      GlobalMsgCreator.LOGIN_INVALID_CREDENTIALS_TITLE
    );
  }

  @ExceptionHandler(DisabledException.class)
  public ProblemDetail handleDisabled(DisabledException e) {
    return ExceptionResponseCreator.createProblemDetailAndLog(
      e,
      HttpStatus.UNAUTHORIZED,
      GlobalMsgCreator.LOGIN_DISABLED_TITLE
    );
  }
}