package com.cloudsolux.foods.finances_service.api.expense.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cloudsolux.foods.finances_service.api.expense.dto.ExpenseCreationRequest;
import com.cloudsolux.foods.finances_service.app.expense.dto.ExpenseResponse;
import com.cloudsolux.foods.finances_service.app.expense.handler.ExpenseCreationHandler;
import com.cloudsolux.foods.finances_service.domain.expense.command.ExpenseCreationCommand;
import com.cloudsolux.foods.finances_service.domain.expense.util.ExpenseMsgCreator;
import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/expenses")
public final class ExpenseCreationController {
  
  private final ExpenseCreationHandler creationHandler;

  @Operation(
    summary = ExpenseMsgCreator.NEW_EXPENSE_SUMMARY,
    description = ExpenseMsgCreator.NEW_EXPENSE_DESCRIPTION,
    tags = { "Departamentos" },
    responses = {
			@ApiResponse(
				responseCode = "201",
				description = GlobalMsgCreator.RESPONSE_201,
				content = @Content(
					mediaType = "application/json",
					schema = @Schema(implementation=ExpenseResponse.class)
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
  public ResponseEntity<List<ExpenseResponse>> create(
    @RequestBody
    @Valid
    List<ExpenseCreationRequest> dto
  ) {
    List<ExpenseCreationCommand> commands = dto.stream()
      .map(ExpenseCreationRequest::toCommand)
      .toList();

    List<ExpenseResponse> responses = creationHandler.create(commands);

    List<Long> createdIdList = responses.stream()
      .map(ExpenseResponse::getId)
      .toList();

    URI location = ServletUriComponentsBuilder
      .fromCurrentRequest()
      .path("/{id}")
      .buildAndExpand(createdIdList)
      .toUri();

    return ResponseEntity.created(location)
      .body(responses);
  }
}