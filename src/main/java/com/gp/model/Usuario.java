package com.gp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
public class Usuario implements Serializable  {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, length = 150)
	private String nome;
	@Column(nullable = false, unique = true, updatable = false, length = 15)
	private String cpf;
	@Column ( nullable = false ,length = 3)
	private Integer idade;
	@Column(nullable = false, length = 50 , unique= true)
	private String email;
	@Column(nullable = false, length = 20)
	private String telefone;
	@Column(nullable = false)
	private String senha;
	
	@OneToMany(mappedBy = "usuario" , cascade = CascadeType.REMOVE)
	 @LazyCollection(LazyCollectionOption.FALSE)
	private List<Personagem> personagens = new ArrayList<>();
	
	public Usuario() {
		super();
	}


	public Usuario(String nome, String cpf, Integer idade, String email, String telefone, String senha) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
		this.email = email;
		this.telefone = telefone;
		this.senha = senha;
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


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public Integer getIdade() {
		return idade;
	}


	public void setIdade(Integer idade) {
		this.idade = idade;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public List<Personagem> getPersonagems() {
		return personagens;
	}


	public void setPersonagems(List<Personagem> personagems) {
		this.personagens = personagems;
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
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
}
