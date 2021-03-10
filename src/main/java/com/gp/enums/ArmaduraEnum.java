package com.gp.enums;

public enum ArmaduraEnum {
	
	LEVE("LEVE"),
	COURO("COURO"),
	PESADA("PESADA");
	
	private String valor;


	private ArmaduraEnum() {
	}

	
	private ArmaduraEnum(String valor) {
		this.valor = valor;
	}
	
	public String getValor() {
		return valor;
	}



	public void setValor(String valor) {
		this.valor = valor;
	}


}
