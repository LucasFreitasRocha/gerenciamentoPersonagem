package com.gp.enums;

public enum CorCabeloEnum {

	PETRO("PETRO"),
	lOIRO("LOIRO"),
	RUIVO("RUIVO");
	
	private String valor;


	private CorCabeloEnum() {
	}

	
	private CorCabeloEnum(String valor) {
		this.valor = valor;
	}
	
	public String getValor() {
		return valor;
	}



	public void setValor(String valor) {
		this.valor = valor;
	}

	
}
