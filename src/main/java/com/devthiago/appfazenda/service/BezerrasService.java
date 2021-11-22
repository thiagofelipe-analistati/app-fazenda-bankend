package com.devthiago.appfazenda.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.devthiago.appfazenda.entities.Bezerras;
import com.devthiago.appfazenda.repositories.BezerrasRepository;
import com.devthiago.appfazenda.service.exceptions.DatabaseExcepetion;
import com.devthiago.appfazenda.service.exceptions.ResourceNotFoundException;


@Service
public class BezerrasService {
	
	@Autowired
	private BezerrasRepository userRepository;
	public List<Bezerras> findAll(){
		return userRepository.findAll();

	}
	public Bezerras findById(Long id) {
		Optional<Bezerras> obj = userRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	public Bezerras Insert(Bezerras obj) {
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
	public Bezerras update(Long id, Bezerras obj) {
		try {
		Bezerras entity = userRepository.getOne(id);
		updateData(entity, obj);
		return userRepository.save(entity);
		} catch (EntityNotFoundException e) {
		throw new ResourceNotFoundException(id);
		}
	}
	private void updateData(Bezerras entity, Bezerras obj) {
		entity.setDataNascimento(obj.getDataNascimento());
		entity.setIdentificacao(obj.getIdentificacao());
		entity.setProprietario(obj.getProprietario());
		entity.setMatrizes(obj.getMatrizes());
	}
}
