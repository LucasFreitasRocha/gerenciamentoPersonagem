package com.gp.enums;

public enum FisicoEnum {

	MAGRO("MAGRO"),
	ACIMA_DO_PESO("ACIMAPESO"),
	MUSCULOSO("MUSCULOSO");
	
	
	private String valor;


	private FisicoEnum() {
	}

	
	private FisicoEnum(String valor) {
		this.valor = valor;
	}
	
	public String getValor() {
		return valor;
	}



	public void setValor(String valor) {
		this.valor = valor;
	}

}
