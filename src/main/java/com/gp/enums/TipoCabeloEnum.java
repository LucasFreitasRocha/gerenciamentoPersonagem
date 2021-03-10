package com.gp.enums;

public enum TipoCabeloEnum {
	
	RASPADO("RASPADO"),
	CURTO("CURTO"),
	MEDIO("MEDIO"),
	LONGO("LONGO");

	private String valor;

	private TipoCabeloEnum() {
	}

	private TipoCabeloEnum(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

}
