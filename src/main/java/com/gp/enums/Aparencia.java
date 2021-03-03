package com.gp.enums;

public enum Aparencia {
	
	MASCULINA("MASCULINA"),
	FEMINIA("FEMINIA");

	private String valor;


	private Aparencia() {
	}

	
	private Aparencia(String valor) {
		this.valor = valor;
	}
	
	public String getValor() {
		return valor;
	}



	public void setValor(String valor) {
		this.valor = valor;
	}

}
