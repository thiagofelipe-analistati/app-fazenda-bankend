package com.devthiago.appfazenda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.devthiago.appfazenda.entities.Proprietarios;
import com.devthiago.appfazenda.repositories.ProprietariosRepository;
import com.devthiago.appfazenda.service.exceptions.DatabaseExcepetion;
import com.devthiago.appfazenda.service.exceptions.ResourceNotFoundException;


@Service
public class ProprietariosService {
	
	@Autowired
	private ProprietariosRepository userRepository;
	public List<Proprietarios> findAll(){
		return userRepository.findAll();

	}
	public Proprietarios findById(Long id) {
		Optional<Proprietarios> obj = userRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	public Proprietarios Insert(Proprietarios obj) {
		return userRepository.save(obj);
	}
	public void delete(Long id) {
		try {
			userRepository.deleteById(id);
		} catch ( EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseExcepetion(e.getMessage());
		}
	}
	public Proprietarios update(Long id, Proprietarios obj) {
		Proprietarios entity = userRepository.getOne(id);
		updateData(entity, obj);
		return userRepository.save(entity);
		
	}
	private void updateData(Proprietarios entity, Proprietarios obj) {
		entity.setName(obj.getName());
	}
}
