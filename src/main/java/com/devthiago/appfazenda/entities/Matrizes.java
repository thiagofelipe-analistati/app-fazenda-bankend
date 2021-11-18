package com.devthiago.appfazenda.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"Identificacao"})})
public class Matrizes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long Identificacao;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy" , timezone = "GMT")
	private Date dataNascimento;

	@ManyToOne
	private Proprietarios proprietarios;
	
	public Matrizes() {
	}
	
	public Matrizes(Long id, Long identificacao, Date dataNascimento, Proprietarios proprietarios) {
		this.id = id;
		Identificacao = identificacao;
		this.dataNascimento = dataNascimento;
		this.proprietarios = proprietarios;
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

	public Proprietarios getProprietarios() {
		return proprietarios;
	}

	public void setProprietarios(Proprietarios proprietarios) {
		this.proprietarios = proprietarios;
	}
	
}
