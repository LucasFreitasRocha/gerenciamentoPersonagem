package com.gp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

import com.gp.enums.AparenciaEnum;
import com.gp.enums.ArmaduraEnum;
import com.gp.enums.FisicoEnum;

@Embeddable
public class Corpo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(nullable = false, length = 20)
	@Enumerated(EnumType.STRING)
	@NotNull(message = "Escolha pelo menos uma aparencia")
	private AparenciaEnum aparencia;
	@Column(nullable = false, length = 20)
	@NotNull(message = "Escolha um fisco")
	@Enumerated(EnumType.STRING)
	private FisicoEnum fisico;
	@Column(nullable = false, length = 20)
	@Enumerated(EnumType.STRING)
	private ArmaduraEnum armadura;

	public Corpo() {
		super();
	}

	public Corpo(AparenciaEnum aparencia, FisicoEnum fisico, ArmaduraEnum armadura) {
		super();
		this.aparencia = aparencia;
		this.fisico = fisico;
		this.armadura = armadura;
	}

	public AparenciaEnum getAparencia() {
		return aparencia;
	}

	public void setAparencia(AparenciaEnum aparencia) {
		this.aparencia = aparencia;
	}

	public FisicoEnum getFisico() {
		return fisico;
	}

	public void setFisico(FisicoEnum fisico) {
		this.fisico = fisico;
	}

	public ArmaduraEnum getArmadura() {
		return armadura;
	}

	public void setArmadura(ArmaduraEnum pesada) {
		this.armadura = pesada;
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 37 * hash + Objects.hashCode(this.armadura);

		hash = 37 * hash + Objects.hashCode(this.aparencia);
		hash = 37 * hash + Objects.hashCode(this.fisico);
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
		Corpo other = (Corpo) obj;
		if (this.armadura != other.armadura && this.aparencia != other.aparencia && this.fisico != other.fisico)
			return false;

		return true;
	}

}
