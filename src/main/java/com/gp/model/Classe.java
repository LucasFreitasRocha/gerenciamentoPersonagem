package com.gp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.gp.enums.TipoClasseEnum;

@Embeddable
public class Classe implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	@Column(nullable = false, length = 20)
	@Enumerated(EnumType.STRING)
	@NotNull(message = "escolha uma classe")
	private TipoClasseEnum tipoClasse;
	@Column(nullable = false, length = 2)
	@Max(value = 10)
	@Min(value = 6)
	private Integer forca;
	@Column(nullable = false, length = 2)
	@Max(value = 10)
	@Min(value = 6)
	private Integer inteligencia;
	@Column(nullable = false, length = 2)
	@Max(value = 10)
	@Min(value = 6)
	private Integer agilidade;
	




	public Classe() {
		super();
	}


	public Classe(TipoClasseEnum tipoClasse, Integer forca, Integer inteligencia, Integer agilidade) {
		super();
		this.tipoClasse = tipoClasse;
		this.forca = forca;
		this.inteligencia = inteligencia;
		this.agilidade = agilidade;
	}





	public TipoClasseEnum getTipoClasse() {
		return tipoClasse;
	}


	public void setTipoClasse(TipoClasseEnum tipoClasse) {
		this.tipoClasse = tipoClasse;
	}


	public Integer getForca() {
		return forca;
	}


	public void setForca(Integer forca) {
		this.forca = forca;
	}


	public Integer getInteligencia() {
		return inteligencia;
	}


	public void setInteligencia(Integer inteligencia) {
		this.inteligencia = inteligencia;
	}


	public Integer getAgilidade() {
		return agilidade;
	}


	public void setAgilidade(Integer agilidade) {
		this.agilidade = agilidade;
	}





	@Override
	public int hashCode() {
		 int hash = 5;
	        hash = 37 * hash + Objects.hashCode(this.tipoClasse); 
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
		Classe other = (Classe) obj;
		if(this.tipoClasse != other.tipoClasse)
			return false;
		return true;
	}
	
	
	

}
