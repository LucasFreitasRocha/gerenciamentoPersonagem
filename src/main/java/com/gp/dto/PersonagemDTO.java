package com.gp.dto;

import com.gp.enums.AparenciaEnum;
import com.gp.enums.CorCabeloEnum;
import com.gp.enums.CorOlhosEnum;
import com.gp.enums.FisicoEnum;
import com.gp.enums.SexoEnum;
import com.gp.enums.TipoCabeloEnum;
import com.gp.enums.TipoClasseEnum;

public class PersonagemDTO {
	private Long UsuarioId;
	private TipoClasseEnum tipoClasse;
	private String nome;
	private SexoEnum sexo;
	private AparenciaEnum aparencia;
	private CorCabeloEnum corCabelo;
	private CorOlhosEnum corOlhos;
	private TipoCabeloEnum TipoCabelo;
	private  FisicoEnum fisico;
	
	

	public PersonagemDTO() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Long getUsuarioId() {
		return UsuarioId;
	}



	public void setUsuarioId(Long usuarioId) {
		UsuarioId = usuarioId;
	}



	public TipoClasseEnum getTipoClasse() {
		return tipoClasse;
	}



	public void setTipoClasse(TipoClasseEnum tipoClasse) {
		this.tipoClasse = tipoClasse;
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



	public AparenciaEnum getAparencia() {
		return aparencia;
	}



	public void setAparencia(AparenciaEnum aparencia) {
		this.aparencia = aparencia;
	}



	public CorCabeloEnum getCorCabelo() {
		return corCabelo;
	}



	public void setCorCabelo(CorCabeloEnum corCabelo) {
		this.corCabelo = corCabelo;
	}



	public CorOlhosEnum getCorOlhos() {
		return corOlhos;
	}



	public void setCorOlhos(CorOlhosEnum corOlhos) {
		this.corOlhos = corOlhos;
	}



	public TipoCabeloEnum getTipoCabelo() {
		return TipoCabelo;
	}



	public void setTipoCabelo(TipoCabeloEnum tipoCabelo) {
		TipoCabelo = tipoCabelo;
	}



	public FisicoEnum getFisico() {
		return fisico;
	}



	public void setFisico(FisicoEnum fisico) {
		this.fisico = fisico;
	}

	
}
