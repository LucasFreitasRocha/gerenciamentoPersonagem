package com.gp.enums;

public enum Sexo {

	MASCULINO("MASCULINO"),
	FEMINIO("FEMININO"),
	OUTROS("OUTROS");
	
	private String valor;


	private Sexo() {
	}

	
	private Sexo(String valor) {
		this.valor = valor;
	}
	
	public String getValor() {
		return valor;
	}



	public void setValor(String valor) {
		this.valor = valor;
	}

}
