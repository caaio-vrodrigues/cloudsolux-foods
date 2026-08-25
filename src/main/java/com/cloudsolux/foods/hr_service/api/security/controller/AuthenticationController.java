package com.cloudsolux.foods.hr_service.api.security.controller;

import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.hr_service.api.security.dto.LoginRequest;
import com.cloudsolux.foods.hr_service.app.security.dto.LoginResponse;
import com.cloudsolux.foods.hr_service.app.security.handler.AuthenticationHandler;
import com.cloudsolux.foods.hr_service.domain.security.util.SecurityMsgCreator;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public final class AuthenticationController {

  private final AuthenticationHandler authHandler;

  @Operation(
    summary = SecurityMsgCreator.AUTHENTICATION_SUMMARY,
    description = SecurityMsgCreator.AUTHENTICATION_DESCRIPTION,
    tags = { "Autenticações" },
    responses = {
			@ApiResponse(
				responseCode = "200",
				description = GlobalMsgCreator.RESPONSE_200,
				content = @Content(
					mediaType = "application/json",
					schema = @Schema(implementation=LoginResponse.class)
				)
			),
			@ApiResponse(
				responseCode = "400",
				description = GlobalMsgCreator.RESPONSE_400,
				content = @Content(
					mediaType = "application/json",
					schema = @Schema(implementation=ProblemDetail.class)
				)
			),
			@ApiResponse(
				responseCode = "401",
				description = GlobalMsgCreator.RESPONSE_401,
				content = @Content(
					mediaType = "application/json",
					schema = @Schema(implementation=ProblemDetail.class)
				)
			),
			@ApiResponse(
				responseCode = "500",
				description = GlobalMsgCreator.RESPONSE_500,
				content = @Content(
					mediaType = "application/json",
					schema = @Schema(implementation=ProblemDetail.class)
				)
			)
    }
	)
  @PostMapping("/login")
  public ResponseEntity<LoginResponse> login(
    @RequestBody 
    @Valid
    LoginRequest request
  ) {
    LoginResponse token = authHandler
      .authenticate(request.toCommand());

    return ResponseEntity.ok(token);
  }
}