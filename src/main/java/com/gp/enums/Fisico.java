package com.gp.enums;

public enum Fisico {

	MAGRO("MAGRO"),
	ACIMA_DO_PESO("ACIMAPESO"),
	MUSCULOSO("MUSCULOSO");
	
	
	private String valor;


	private Fisico() {
	}

	
	private Fisico(String valor) {
		this.valor = valor;
	}
	
	public String getValor() {
		return valor;
	}



	public void setValor(String valor) {
		this.valor = valor;
	}

}
