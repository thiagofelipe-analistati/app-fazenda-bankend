package com.devthiago.appfazenda.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.devthiago.appfazenda.entities.Bezerros;
import com.devthiago.appfazenda.repositories.BezerrosRepository;
import com.devthiago.appfazenda.service.exceptions.DatabaseExcepetion;
import com.devthiago.appfazenda.service.exceptions.ResourceNotFoundException;


@Service
public class BezerrosService {
	
	@Autowired
	private BezerrosRepository userRepository;
	public List<Bezerros> findAll(){
		return userRepository.findAll();

	}
	public Bezerros findById(Long id) {
		Optional<Bezerros> obj = userRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	public Bezerros Insert(Bezerros obj) {
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
	public Bezerros update(Long id, Bezerros obj) {
		try {
		Bezerros entity = userRepository.getOne(id);
		updateData(entity, obj);
		return userRepository.save(entity);
		} catch (EntityNotFoundException e) {
		throw new ResourceNotFoundException(id);
		}
		
	}
	private void updateData(Bezerros entity, Bezerros obj) {
		entity.setDataNascimento(obj.getDataNascimento());
		entity.setIdentificacao(obj.getIdentificacao());
		entity.setProprietario(obj.getProprietario());
		entity.setMatrizes(obj.getMatrizes());
	}
}
