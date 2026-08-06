package com.cloudsolux.foods.hr_service.api.employee.controller;

import java.net.URI;

import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.hr_service.api.employee.dto.EmployeeCreationRequest;
import com.cloudsolux.foods.hr_service.app.employee.dto.EmployeeResponse;
import com.cloudsolux.foods.hr_service.app.employee.handler.EmployeeCreationHandler;
import com.cloudsolux.foods.hr_service.domain.employee.util.EmployeeMsgCreator;
import com.cloudsolux.foods.hr_service.domain.employee.util.EmployeeValidationAux;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/employees")
public final class EmployeeCreationController {

  private final EmployeeCreationHandler employeeCreationHandler;
  
  @Operation(
    summary = EmployeeMsgCreator.NEW_EMPLOYEE_SUMMARY,
    description = EmployeeMsgCreator.NEW_EMPLOYEE_DESCRIPTION,
    tags = { "Colaboradores" },
    responses = {
			@ApiResponse(
				responseCode = "201",
				description = GlobalMsgCreator.RESPONSE_201,
				content = @Content(
					mediaType = "application/json",
					schema = @Schema(implementation=EmployeeResponse.class)
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
				responseCode = "409",
				description = GlobalMsgCreator.RESPONSE_409,
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
  @PostMapping
  public ResponseEntity<EmployeeResponse> create(
    @Valid
    @RequestBody
    EmployeeCreationRequest request
  ) {
    EmployeeValidationAux.validateDependency(employeeCreationHandler, "EmployeeCreationHandler");

    EmployeeResponse response = employeeCreationHandler
      .create(request.toEmployeeCommand(), request.toUserAccountCommand());

    EmployeeValidationAux.validateDependency(response, "EmployeeCreationHandler");

    URI location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(response.getId()) 
			.toUri();

    return ResponseEntity.created(location)
      .body(response);
  }
}