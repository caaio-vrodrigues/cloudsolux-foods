package com.cloudsolux.foods.hr_service.api.department.controller;

import java.net.URI;

import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.hr_service.api.department.dto.DepartmentCreationRequest;
import com.cloudsolux.foods.hr_service.app.department.dto.DepartmentResponse;
import com.cloudsolux.foods.hr_service.app.department.handler.DepartmentCreationHandler;
import com.cloudsolux.foods.hr_service.domain.department.util.DepartmentValidationAux;
import com.cloudsolux.foods.hr_service.domain.department.util.DepartmentMsgCreator;

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
@RequestMapping("/api/v1/departments")
public final class DepartmentCreationController {

  private final DepartmentCreationHandler handler;

  @Operation(
    summary = DepartmentMsgCreator.NEW_DEPARTMENT_SUMMARY,
    description = DepartmentMsgCreator.NEW_DEPARTMENT_DESCRIPTION,
    tags = { "Departamentos" },
    responses = {
			@ApiResponse(
				responseCode = "201",
				description = GlobalMsgCreator.RESPONSE_201,
				content = @Content(
					mediaType = "application/json",
					schema = @Schema(implementation=DepartmentResponse.class)
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
  public ResponseEntity<DepartmentResponse> create(
    @RequestBody
    @Valid
    DepartmentCreationRequest request
  ) {
		DepartmentValidationAux.validateDependency(handler, "DepartmentCreationHandler");
    DepartmentResponse response = handler.create(request.toCommand());
		DepartmentValidationAux.validateDependency(response, "DepartmentResponse");

    URI location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(response.getId()) 
			.toUri();

    return ResponseEntity.created(location)
      .body(response);
  }
}