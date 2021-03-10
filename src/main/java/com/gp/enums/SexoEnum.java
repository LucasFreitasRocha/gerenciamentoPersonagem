package com.gp.enums;

public enum SexoEnum {

	MASCULINO("MASCULINO"),
	FEMINIO("FEMININO"),
	OUTROS("OUTROS");
	
	private String valor;


	private SexoEnum() {
	}

	
	private SexoEnum(String valor) {
		this.valor = valor;
	}
	
	public String getValor() {
		return valor;
	}



	public void setValor(String valor) {
		this.valor = valor;
	}

}
