package com.cloudsolux.foods.global_services.domain.global.model;

public enum Role {

  ADMIN("ADMIN"),
	EMPLOYEE("EMPLOYEE"),
	MANAGER("MANAGER");
	
	public final String type;
	
	private Role(String type) {
		this.type = type;
	}
}