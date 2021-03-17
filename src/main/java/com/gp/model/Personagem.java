package com.gp.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.gp.enums.SexoEnum;

@Entity
public class Personagem implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 150)
	private String nome;
	@Column(nullable = false, length = 20)
	@Enumerated(EnumType.STRING)
	@Valid
	@NotNull(message = "Escolha um genero.")
	private SexoEnum sexo;

	@ManyToOne
	@JoinColumn(name = "usuario_id", referencedColumnName = "id", nullable = false)
	private Usuario usuario;

	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "rosto_id", nullable = false)
	@Valid
	@NotNull(message = "Escolha uma rosto.")
	private Rosto rosto;

	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "classe_id", nullable = false)
	@Valid
	@NotNull(message = "Escolha uma classe.")
	private Classe classe;

	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "corpo_id", nullable = false)
	@Valid
	@NotNull(message = "Escolha um corpo.")
	private Corpo corpo;

	public Personagem() {
		super();
	}

	public Personagem(String nome, SexoEnum sexo) {
		super();
		this.nome = nome;
		this.sexo = sexo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public SexoEnum getSexo() {
		return sexo;
	}

	public void setSexo(SexoEnum sexo) {
		this.sexo = sexo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Rosto getRosto() {
		return rosto;
	}

	public void setRosto(Rosto rosto) {
		this.rosto = rosto;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public Corpo getCorpo() {
		return corpo;
	}

	public void setCorpo(Corpo corpo) {
		this.corpo = corpo;
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
		Personagem other = (Personagem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
