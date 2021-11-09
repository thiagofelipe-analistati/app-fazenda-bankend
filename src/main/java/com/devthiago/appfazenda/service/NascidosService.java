package com.devthiago.appfazenda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devthiago.appfazenda.entities.Nascidos;
import com.devthiago.appfazenda.repositories.NascidosRepository;


@Service
public class NascidosService {
	
	@Autowired
	private NascidosRepository userRepository;
	public List<Nascidos> findAll(){
		return userRepository.findAll();

	}
	public Nascidos findById(Long id) {
		Optional<Nascidos> obj = userRepository.findById(id);
		return obj.get();
	}
	public Nascidos Insert(Nascidos obj) {
		return userRepository.save(obj);
	}
	public void delete(Long id) {
		userRepository.deleteById(id);
	}
	public Nascidos update(Long id, Nascidos obj) {
		Nascidos entity = userRepository.getOne(id);
		updateData(entity, obj);
		return userRepository.save(entity);
		
	}
	private void updateData(Nascidos entity, Nascidos obj) {
		entity.setDataNascimento(obj.getDataNascimento());
		entity.setIdentificacao(obj.getIdentificacao());
		entity.setSexo(obj.getSexo());
		entity.setProprietario(obj.getProprietario());
		entity.setMatrizes(obj.getMatrizes());
	}
}
