package com.gp.enums;

public enum CorCabelo {

	PETRO("PETRO"),
	lOIRO("LOIRO"),
	RUIVO("RUIVO");
	
	private String valor;
	
	

	


	private CorCabelo() {
	}

	
	private CorCabelo(String valor) {
		this.valor = valor;
	}
	
	public String getValor() {
		return valor;
	}



	public void setValor(String valor) {
		this.valor = valor;
	}

	
}
