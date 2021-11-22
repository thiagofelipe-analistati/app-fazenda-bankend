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

import com.devthiago.appfazenda.entities.Bezerros;
import com.devthiago.appfazenda.service.BezerrosService;

@RestController
@RequestMapping (value = "/bezerros")
public class BezerrosResource {
	
	@Autowired
	private BezerrosService service;
	@GetMapping
	public ResponseEntity<List<Bezerros>> findall(){
		
		List<Bezerros> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<Bezerros> FindById(@PathVariable Long id){ 
		Bezerros obj  = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	@PostMapping
	public ResponseEntity<Bezerros> Insert(@RequestBody Bezerros obj){
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
	public ResponseEntity<Bezerros> update (@PathVariable Long id,@RequestBody Bezerros obj ){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
