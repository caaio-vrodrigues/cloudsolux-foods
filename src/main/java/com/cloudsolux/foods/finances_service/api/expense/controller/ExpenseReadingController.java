package com.cloudsolux.foods.finances_service.api.expense.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloudsolux.foods.finances_service.app.expense.dto.ExpenseResponse;
import com.cloudsolux.foods.finances_service.app.expense.handler.ExpenseReadingHandler;
import com.cloudsolux.foods.finances_service.domain.expense.util.ExpenseMsgCreator;
import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/expenses")
public final class ExpenseReadingController {

  private final ExpenseReadingHandler reader;
 
  @Operation(
    summary = ExpenseMsgCreator.LISTING_EXPENSES_SUMMARY,
    description = ExpenseMsgCreator.LISTING_EXPENSES_DESCRIPTION,
    tags = { "Despesas" },
    responses = {
			@ApiResponse(
				responseCode = "200",
				description = GlobalMsgCreator.RESPONSE_200,
				content = @Content(
					mediaType = "application/json"
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
  @GetMapping
  public ResponseEntity<Page<ExpenseResponse>> findAll(
    @PageableDefault(size=20, sort="id")
    Pageable pageable
  ) {
    Page<ExpenseResponse> pagedResponses = reader.findAll(pageable);
    return ResponseEntity.ok(pagedResponses);
  }
}