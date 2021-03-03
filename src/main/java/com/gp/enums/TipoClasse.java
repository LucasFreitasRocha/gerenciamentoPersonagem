package com.gp.enums;

public enum TipoClasse {
	
	MAGO("MAGO"),
	LADINO("LADINO"),
	GUERREIRO("GUERREIRO");
	
	private String valor;


	private TipoClasse() {
	}

	
	private TipoClasse(String valor) {
		this.valor = valor;
	}
	
	public String getValor() {
		return valor;
	}



	public void setValor(String valor) {
		this.valor = valor;
	}


}
