package com.gp.enums;

public enum CorOlhosEnum {

	PETRO("PETRO"),
	AZUL("AZUL"),
	CASTANHO("CASTANHO");
	
	private String valor;


	private CorOlhosEnum() {
	}

	
	private CorOlhosEnum(String valor) {
		this.valor = valor;
	}
	
	public String getValor() {
		return valor;
	}



	public void setValor(String valor) {
		this.valor = valor;
	}

}
