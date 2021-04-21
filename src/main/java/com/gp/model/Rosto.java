package com.gp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

import com.gp.enums.CorCabeloEnum;
import com.gp.enums.CorOlhosEnum;
import com.gp.enums.TipoCabeloEnum;

@Embeddable
public class Rosto implements Serializable  {

	private static final long serialVersionUID = 1L;


	@Column(nullable = false, length = 20)
	@Enumerated(EnumType.STRING)
	@NotNull(message = "Cor de cabelo obrigatorio")
	private CorCabeloEnum corCabelo;

	@Column(nullable = false, length = 20)
	@Enumerated(EnumType.STRING)
	@NotNull(message = "tamanho do cabelo obrigatorio")
	private TipoCabeloEnum tipoCabelo; 

	@Column(nullable = false, length = 20)
	@Enumerated(EnumType.STRING)
	@NotNull(message = "Cor de olho obrigatorio")
	private CorOlhosEnum corOlhos;
	
	
	
	public Rosto() {
		super();
	}


	public Rosto(CorCabeloEnum corCabelo, TipoCabeloEnum tipoCabelo, CorOlhosEnum corOlhos) {
		super();
		this.corCabelo = corCabelo;
		this.tipoCabelo = tipoCabelo;
		this.corOlhos = corOlhos;
	}




	public CorCabeloEnum getCorCabelo() {
		return corCabelo;
	}


	public void setCorCabelo(CorCabeloEnum corCabelo) {
		this.corCabelo = corCabelo;
	}


	public TipoCabeloEnum getTipoCabelo() {
		return tipoCabelo;
	}


	public void setTipoCabelo(TipoCabeloEnum tipoCabelo) {
		this.tipoCabelo = tipoCabelo;
	}


	public CorOlhosEnum getCorOlhos() {
		return corOlhos;
	}


	public void setCorOlhos(CorOlhosEnum corOlhos) {
		this.corOlhos = corOlhos;
	}



	


	@Override
	public int hashCode() {
		 int hash = 5;
	        hash = 37 * hash + Objects.hashCode(this.corCabelo); 
	        hash = 37 * hash + Objects.hashCode(this.corOlhos); 
	        hash = 37 * hash + Objects.hashCode(this.tipoCabelo); 
	        return hash;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rosto other = (Rosto) obj;
		if(this.corCabelo != other.corCabelo && this.corOlhos != other.corOlhos && this.tipoCabelo != other.tipoCabelo)
			return false;
		
		return true;
	}
	
	
	
	
}
