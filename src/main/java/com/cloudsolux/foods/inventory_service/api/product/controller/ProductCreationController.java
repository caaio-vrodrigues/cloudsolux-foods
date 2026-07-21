package com.cloudsolux.foods.inventory_service.api.product.controller;

import java.net.URI;

import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cloudsolux.foods.global_services.domain.global.util.GlobalMsgCreator;
import com.cloudsolux.foods.inventory_service.api.product.dto.ProductCreationRequest;
import com.cloudsolux.foods.inventory_service.app.product.dto.ProductResponse;
import com.cloudsolux.foods.inventory_service.app.product.handler.ProductCreationHandler;
import com.cloudsolux.foods.inventory_service.domain.product.util.ProductMsgCreator;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductCreationController {

  private final ProductCreationHandler productCreationHandler;
  
  @Operation(
    summary = ProductMsgCreator.NEW_PRODUCT_SUMMARY,
    description = ProductMsgCreator.NEW_PRODUCT_DESCRIPTION,
    tags = { "Produtos" },
    responses = {
			@ApiResponse(
				responseCode = "201",
				description = GlobalMsgCreator.RESPONSE_201,
				content = @Content(
					mediaType = "application/json",
					schema = @Schema(implementation=ProductResponse.class)
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
	public ResponseEntity<ProductResponse> create(
		@RequestBody 
		@Valid
		ProductCreationRequest dto 	
 	) {
		log.info("Iniciando criação de novo produto.");
		ProductResponse resp = productCreationHandler
			.create(dto.toCommand());
		URI location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(resp.getId())
			.toUri();
		log.info("Produto criado com sucesso. id: {}", resp.getId());
		return ResponseEntity
			.created(location)
			.body(resp);
	}
}