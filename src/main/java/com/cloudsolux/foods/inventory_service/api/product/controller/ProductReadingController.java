package com.cloudsolux.foods.inventory_service.api.product.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.inventory_service.app.product.dto.ProductResponse;
import com.cloudsolux.foods.inventory_service.app.product.handler.ProductReadingHandler;
import com.cloudsolux.foods.inventory_service.domain.product.util.ProductMsgCreator;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public final class ProductReadingController {

  private final ProductReadingHandler readerHandler;
 
  @Operation(
    summary = ProductMsgCreator.LISTING_PRODUCTS_SUMMARY,
    description = ProductMsgCreator.LISTING_PRODUCTS_DESCRIPTION,
    tags = { "Produtos" },
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
  public ResponseEntity<Page<ProductResponse>> findAll(
    @PageableDefault(size=20, sort="id")
    Pageable pageable
  ) {
    Page<ProductResponse> pagedProducts = readerHandler.findAll(pageable);
    return ResponseEntity.ok(pagedProducts);
  }
}