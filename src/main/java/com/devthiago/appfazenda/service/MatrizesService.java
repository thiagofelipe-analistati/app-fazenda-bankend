package com.devthiago.appfazenda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devthiago.appfazenda.entities.Matrizes;
import com.devthiago.appfazenda.entities.Proprietarios;
import com.devthiago.appfazenda.repositories.MatrizesRepository;


@Service
public class MatrizesService {
	
	@Autowired
	private MatrizesRepository userRepository;
	public List<Matrizes> findAll(){
		return userRepository.findAll();

	}
	public Matrizes findById(Long id) {
		Optional<Matrizes> obj = userRepository.findById(id);
		return obj.get();
	}
	public Matrizes Insert(Matrizes obj) {
		return userRepository.save(obj);
	}
	public void delete(Long id) {
		userRepository.deleteById(id);
	}
	public Matrizes update(Long id, Matrizes obj) {
		Matrizes entity = userRepository.getOne(id);
		updateData(entity, obj);
		return userRepository.save(entity);
		
	}
	private void updateData(Matrizes entity, Matrizes obj) {
		entity.setIdentificacao(obj.getIdentificacao());
		entity.setDataNascimento(obj.getDataNascimento());
		entity.setProprietarios(obj.getProprietarios());
	}
}
