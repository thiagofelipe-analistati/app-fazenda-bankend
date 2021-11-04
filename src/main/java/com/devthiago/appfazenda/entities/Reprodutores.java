package com.devthiago.appfazenda.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Reprodutores {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long Identificacao;
	private Date dataNascimento;
	

	public Reprodutores() {
	}
	public Reprodutores(Long id, Long identificacao, Date dataNascimento) {
		this.id = id;
		Identificacao = identificacao;
		this.dataNascimento = dataNascimento;
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
}
