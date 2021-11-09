package com.devthiago.appfazenda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devthiago.appfazenda.entities.Nascidos;

public interface NascidosRepository extends JpaRepository<Nascidos, Long>{
	
}
