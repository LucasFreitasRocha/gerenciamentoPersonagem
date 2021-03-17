package com.gp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.gp.enums.AparenciaEnum;

@Entity
public class Corpo implements Serializable  {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, length = 20)
	@Enumerated(EnumType.STRING)
	@NotNull(message = "Escolha pelo menos uma aparencia")
	private AparenciaEnum aparencia;
	@Column(nullable = false, length = 20)
	@NotBlank(message = "Escolha um fisco")
	private String fisico;
	@Column(nullable = false, length = 20)
	private String armadura;


	public Corpo() {
		super();
	}

	public Corpo(AparenciaEnum aparencia, String fisico, String armadura) {
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

	public AparenciaEnum getAparencia() {
		return aparencia;
	}

	public void setAparencia(AparenciaEnum aparencia) {
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
