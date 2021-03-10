package com.gp.enums;

public enum TipoClasseEnum {
	
	MAGO("MAGO"),
	LADINO("LADINO"),
	GUERREIRO("GUERREIRO");
	
	private String valor;


	private TipoClasseEnum() {
	}

	
	private TipoClasseEnum(String valor) {
		this.valor = valor;
	}
	
	public String getValor() {
		return valor;
	}



	public void setValor(String valor) {
		this.valor = valor;
	}


}
