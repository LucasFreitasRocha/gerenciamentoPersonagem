package com.gp.enums;

public enum Armadura {
	
	LEVE("LEVE"),
	COURO("COURO"),
	PESADA("PESADA");
	
	private String valor;


	private Armadura() {
	}

	
	private Armadura(String valor) {
		this.valor = valor;
	}
	
	public String getValor() {
		return valor;
	}



	public void setValor(String valor) {
		this.valor = valor;
	}


}
