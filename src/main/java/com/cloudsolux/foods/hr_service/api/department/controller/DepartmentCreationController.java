package com.cloudsolux.foods.hr_service.api.department.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cloudsolux.foods.hr_service.api.department.dto.DepartmentCreationRequest;
import com.cloudsolux.foods.hr_service.app.department.dto.DepartmentResponse;
import com.cloudsolux.foods.hr_service.app.department.handler.DepartmentCreationHandler;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/departments")
public class DepartmentCreationController {

  private final DepartmentCreationHandler handler;
  
  @PostMapping
  public ResponseEntity<DepartmentResponse> create(
    @RequestBody
    @Valid
    DepartmentCreationRequest request
  ) {
    DepartmentResponse response = handler.create(request.toCommand());
    URI location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(response.getId()) 
			.toUri();
    return ResponseEntity.created(location).body(response);
  }
}