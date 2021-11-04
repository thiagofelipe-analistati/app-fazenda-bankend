package com.devthiago.appfazenda.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Nascidos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long Identificacao;
	private Date dataNascimento;
	private String Sexo;
	
	@ManyToOne
	private Matrizes matrizes;
	@ManyToOne
	private Proprietarios proprietario;
	
	public Nascidos() {
	}
	public Nascidos(Long id, Long identificacao, Date dataNascimento, String sexo, Matrizes matrizes,
			Proprietarios proprietario) {
		this.id = id;
		this.Identificacao = identificacao;
		this.dataNascimento = dataNascimento;
		this.Sexo = sexo;
		this.matrizes = matrizes;
		this.proprietario = proprietario;
	}
	public String getSexo() {
		return Sexo;
	}
	public void setSexo(String sexo) {
		Sexo = sexo;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdentificacao() {
		return Identificacao;
	}

	public void setIdentificacao(Long identificacao) {
		Identificacao = identificacao;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Matrizes getMatrizes() {
		return matrizes;
	}

	public void setMatrizes(Matrizes matrizes) {
		this.matrizes = matrizes;
	}

	public Proprietarios getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietarios proprietario) {
		this.proprietario = proprietario;
	}
}
