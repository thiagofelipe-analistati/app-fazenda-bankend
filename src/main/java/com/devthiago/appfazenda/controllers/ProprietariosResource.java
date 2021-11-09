package com.devthiago.appfazenda.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devthiago.appfazenda.entities.Proprietarios;
import com.devthiago.appfazenda.service.ProprietariosService;





@RestController //implementação do rest 
@RequestMapping (value = "/proprietarios")
public class ProprietariosResource {
	
	@Autowired
	private ProprietariosService service;
	@GetMapping
	public ResponseEntity<List<Proprietarios>> findall(){
		
		List<Proprietarios> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Proprietarios> FindById(@PathVariable Long id){ 
		Proprietarios obj  = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	@PostMapping
	public ResponseEntity<Proprietarios> Insert(@RequestBody Proprietarios obj){
		obj = service.Insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
}
