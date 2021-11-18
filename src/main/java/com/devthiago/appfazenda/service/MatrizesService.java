package com.devthiago.appfazenda.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.devthiago.appfazenda.entities.Matrizes;
import com.devthiago.appfazenda.repositories.MatrizesRepository;
import com.devthiago.appfazenda.service.exceptions.DatabaseExcepetion;
import com.devthiago.appfazenda.service.exceptions.ResourceNotFoundException;


@Service
public class MatrizesService {
	
	@Autowired
	private MatrizesRepository userRepository;
	public List<Matrizes> findAll(){
		return  userRepository.findAll();
	}
	public Matrizes findById(Long id) {
		Optional<Matrizes> obj = userRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	public Matrizes Insert(Matrizes obj) {
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
	public Matrizes update(Long id, Matrizes obj) {
		try {
		Matrizes entity = userRepository.getOne(id);
		updateData(entity, obj);
		return userRepository.save(entity);
		} catch (EntityNotFoundException e) {
		throw new ResourceNotFoundException(id);
		}
		
	}
	private void updateData(Matrizes entity, Matrizes obj) {
		entity.setIdentificacao(obj.getIdentificacao());
		entity.setDataNascimento(obj.getDataNascimento());
		entity.setProprietarios(obj.getProprietarios());
	}
}
