package com.gp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.gp.enums.TipoClasseEnum;

@Entity
public class Classe implements Serializable  {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, length = 20)
	@Enumerated(EnumType.STRING)
	@NotNull(message = "escolha uma classe")
	private TipoClasseEnum tipoClasse;
	@Column(nullable = false, length = 2)
	@Length(max = 2)
	private Integer forca;
	@Column(nullable = false, length = 2)
	@Length(max = 2)
	private Integer inteligencia;
	@Column(nullable = false, length = 2)
	@Length(max = 2)
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


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
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
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	

}
