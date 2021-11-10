package com.devthiago.appfazenda.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.devthiago.appfazenda.entities.Nascidos;
import com.devthiago.appfazenda.repositories.NascidosRepository;
import com.devthiago.appfazenda.service.exceptions.DatabaseExcepetion;
import com.devthiago.appfazenda.service.exceptions.ResourceNotFoundException;


@Service
public class NascidosService {
	
	@Autowired
	private NascidosRepository userRepository;
	public List<Nascidos> findAll(){
		return userRepository.findAll();

	}
	public Nascidos findById(Long id) {
		Optional<Nascidos> obj = userRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	public Nascidos Insert(Nascidos obj) {
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
	public Nascidos update(Long id, Nascidos obj) {
		try {
		Nascidos entity = userRepository.getOne(id);
		updateData(entity, obj);
		return userRepository.save(entity);
		} catch (EntityNotFoundException e) {
		throw new ResourceNotFoundException(id);
		}
		
	}
	private void updateData(Nascidos entity, Nascidos obj) {
		entity.setDataNascimento(obj.getDataNascimento());
		entity.setIdentificacao(obj.getIdentificacao());
		entity.setSexo(obj.getSexo());
		entity.setProprietario(obj.getProprietario());
		entity.setMatrizes(obj.getMatrizes());
	}
}
