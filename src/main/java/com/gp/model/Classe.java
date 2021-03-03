package com.gp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Classe implements Serializable  {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String tipoClasse;
	private Integer forca;
	private Integer inteligencia;
	private Integer agilidade;
	

	@OneToMany(mappedBy = "classe")
	private List<Personagem> personagens = new ArrayList<>();


	public Classe() {
		super();
	}


	public Classe(String tipoClasse, Integer forca, Integer inteligencia, Integer agilidade,
			List<Personagem> personagens) {
		super();
		this.tipoClasse = tipoClasse;
		this.forca = forca;
		this.inteligencia = inteligencia;
		this.agilidade = agilidade;
		this.personagens = personagens;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTipoClasse() {
		return tipoClasse;
	}


	public void setTipoClasse(String tipoClasse) {
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


	public List<Personagem> getPersonagens() {
		return personagens;
	}


	public void setPersonagens(List<Personagem> personagens) {
		this.personagens = personagens;
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
