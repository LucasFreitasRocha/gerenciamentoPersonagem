package com.gp.enums;

public enum AparenciaEnum {
	
	MASCULINA("MASCULINA"),
	FEMINIA("FEMINIA");

	private String valor;


	private AparenciaEnum() {
	}

	
	private AparenciaEnum(String valor) {
		this.valor = valor;
	}
	
	public String getValor() {
		return valor;
	}



	public void setValor(String valor) {
		this.valor = valor;
	}

}
