package com.cloudsolux.foods.global_services.model;

public enum UnitOfMeasure {

	UN("UNIDADE"),
	KG("QUILO"),
	LT("LITRO"),
	BOX("CAIXA"),
	PCT("PACOTE");
	
	public final String type;
	
	private UnitOfMeasure(String type) {
		this.type = type;
	}
}