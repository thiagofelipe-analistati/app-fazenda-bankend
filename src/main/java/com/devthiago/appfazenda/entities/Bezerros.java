package com.devthiago.appfazenda.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"Identificacao"})})
public class Bezerros {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long Identificacao;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy" , timezone = "GMT")
	private Date dataNascimento;
	
	@ManyToOne
	private Matrizes matrizes;

	@ManyToOne
	private Proprietarios proprietarios;
	
	public Bezerros() {
	}
	public Bezerros(Long id, Long identificacao, Date dataNascimento, Matrizes matrizes,
			Proprietarios proprietario) {
		this.id = id;
		this.Identificacao = identificacao;
		this.dataNascimento = dataNascimento;
		this.matrizes = matrizes;
		this.proprietarios = proprietario;
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
		return proprietarios;
	}

	public void setProprietario(Proprietarios proprietario) {
		this.proprietarios = proprietario;
	}
}
