package com.devthiago.appfazenda.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Proprietarios implements Serializable {
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@JsonIgnore
	@OneToMany(mappedBy = "proprietarios", cascade = CascadeType.ALL)
	private List<Nascidos> nascidos = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "proprietarios", cascade = CascadeType.ALL)
	private List<Matrizes> matrizes = new ArrayList<>();
	@JsonIgnore
	@OneToMany(mappedBy = "proprietarios", cascade = CascadeType.ALL)
	private List<Reprodutores> reprodutores = new ArrayList<>();
	
	public Proprietarios() {
	}
	public Proprietarios(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Nascidos> getNascidos() {
		return nascidos;
	}
	public List<Matrizes> getMatrizes() {
		return matrizes;
	}
	public List<Reprodutores> getReprodutores() {
		return reprodutores;
	}
	
	
}
