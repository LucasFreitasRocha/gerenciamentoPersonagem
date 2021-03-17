package com.gp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.gp.enums.CorCabeloEnum;
import com.gp.enums.TipoCabeloEnum;

@Entity
public class Rosto implements Serializable  {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 20)
	@Enumerated(EnumType.STRING)
	private CorCabeloEnum corCabelo;

	@Column(nullable = false, length = 20)
	@Enumerated(EnumType.STRING)
	private TipoCabeloEnum tipoCabelo;

	@Column(nullable = false, length = 20)
	@Enumerated(EnumType.STRING)
	private CorCabeloEnum corOlhos;
	
	
	
	public Rosto() {
		super();
	}


	public Rosto(CorCabeloEnum corCabelo, TipoCabeloEnum tipoCabelo, CorCabeloEnum corOlhos) {
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


	public CorCabeloEnum getCorOlhos() {
		return corOlhos;
	}


	public void setCorOlhos(CorCabeloEnum corOlhos) {
		this.corOlhos = corOlhos;
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
