package com.gp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Corpo implements Serializable  {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, length = 20)
	private String aparencia;
	@Column(nullable = false, length = 20)
	private String fisico;
	@Column(nullable = false, length = 20)
	private String armadura;
	
	@OneToMany(mappedBy = "corpo")
	private List<Personagem> personagens = new ArrayList<>();

	public Corpo() {
		super();
	}

	public Corpo(String aparencia, String fisico, String armadura) {
		super();
		this.aparencia = aparencia;
		this.fisico = fisico;
		this.armadura = armadura;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAparencia() {
		return aparencia;
	}

	public void setAparencia(String aparencia) {
		this.aparencia = aparencia;
	}

	public String getFisico() {
		return fisico;
	}

	public void setFisico(String fisico) {
		this.fisico = fisico;
	}

	public String getArmadura() {
		return armadura;
	}

	public void setArmadura(String armadura) {
		this.armadura = armadura;
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
		Corpo other = (Corpo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
}
