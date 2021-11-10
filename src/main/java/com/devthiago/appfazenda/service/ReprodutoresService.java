package com.devthiago.appfazenda.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.devthiago.appfazenda.entities.Reprodutores;
import com.devthiago.appfazenda.repositories.ReprodutoresRepository;
import com.devthiago.appfazenda.service.exceptions.DatabaseExcepetion;
import com.devthiago.appfazenda.service.exceptions.ResourceNotFoundException;


@Service
public class ReprodutoresService {
	
	@Autowired
	private ReprodutoresRepository userRepository;
	public List<Reprodutores> findAll(){
		return userRepository.findAll();
	}
	public Reprodutores findById(Long id) {
		Optional<Reprodutores> obj = userRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	public Reprodutores Insert(Reprodutores obj) {
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
	public Reprodutores update(Long id, Reprodutores obj) {
		try {
		Reprodutores entity = userRepository.getOne(id);
		updateData(entity, obj);
		return userRepository.save(entity);
		} catch (EntityNotFoundException e) {
		throw new ResourceNotFoundException(id);
		}
	}
	private void updateData(Reprodutores entity, Reprodutores obj) {
		entity.setIdentificacao(obj.getIdentificacao());
		entity.setDataNascimento(obj.getDataNascimento());
		entity.setProprietarios(obj.getProprietarios());
	}
}
