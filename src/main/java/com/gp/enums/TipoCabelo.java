package com.gp.enums;

public enum TipoCabelo {
	
	RASPADO("RASPADO"),
	CURTO("CURTO"),
	MEDIO("MEDIO"),
	LONGO("LONGO");

	private String valor;

	private TipoCabelo() {
	}

	private TipoCabelo(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

}
