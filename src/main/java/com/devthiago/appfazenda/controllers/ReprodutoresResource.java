package com.devthiago.appfazenda.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devthiago.appfazenda.entities.Reprodutores;
import com.devthiago.appfazenda.service.ReprodutoresService;

@RestController //implementação do rest 
@RequestMapping (value = "/Reprodutores")
public class ReprodutoresResource {
	
	@Autowired
	private ReprodutoresService service;
	@GetMapping
	public ResponseEntity<List<Reprodutores>> findall(){
		
		List<Reprodutores> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	

	@GetMapping(value = "/{id}")
	public ResponseEntity<Reprodutores> FindById(@PathVariable Long id){ 
		Reprodutores obj  = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	@PostMapping
	public ResponseEntity<Reprodutores> Insert(@RequestBody Reprodutores obj){
		obj = service.Insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	@PutMapping(value = "/{id}")
	public ResponseEntity<Reprodutores> update (@PathVariable Long id,@RequestBody Reprodutores obj ){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
