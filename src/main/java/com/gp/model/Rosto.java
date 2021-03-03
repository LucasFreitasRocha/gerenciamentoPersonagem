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
public class Rosto implements Serializable  {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String corCabelo;
	private String tipoCabelo;
	private String corOlhos;
	
	@OneToMany(mappedBy = "rosto")
	private List<Personagem> personagens = new ArrayList<>();
	
	public Rosto() {
		super();
	}


	public Rosto(String corCabelo, String tipoCabelo, String corOlhos) {
		super();
		this.corCabelo = corCabelo;
		this.tipoCabelo = tipoCabelo;
		this.corOlhos = corOlhos;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getCorCabelo() {
		return corCabelo;
	}


	public void setCorCabelo(String corCabelo) {
		this.corCabelo = corCabelo;
	}


	public String getTipoCabelo() {
		return tipoCabelo;
	}


	public void setTipoCabelo(String tipoCabelo) {
		this.tipoCabelo = tipoCabelo;
	}


	public String getCorOlhos() {
		return corOlhos;
	}


	public void setCorOlhos(String corOlhos) {
		this.corOlhos = corOlhos;
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
		Rosto other = (Rosto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
}
