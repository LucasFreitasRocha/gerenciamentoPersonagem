package com.gp.enums;

public enum CorOlhos {

	PETRO("PETRO"),
	AZUL("AZUL"),
	CASTANHO("CASTANHO");
	
	private String valor;


	private CorOlhos() {
	}

	
	private CorOlhos(String valor) {
		this.valor = valor;
	}
	
	public String getValor() {
		return valor;
	}



	public void setValor(String valor) {
		this.valor = valor;
	}

}
