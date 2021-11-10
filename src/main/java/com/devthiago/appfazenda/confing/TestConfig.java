package com.devthiago.appfazenda.confing;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.devthiago.appfazenda.entities.Matrizes;
import com.devthiago.appfazenda.entities.Nascidos;
import com.devthiago.appfazenda.entities.Proprietarios;
import com.devthiago.appfazenda.entities.Reprodutores;
import com.devthiago.appfazenda.repositories.MatrizesRepository;
import com.devthiago.appfazenda.repositories.NascidosRepository;
import com.devthiago.appfazenda.repositories.ProprietariosRepository;
import com.devthiago.appfazenda.repositories.ReprodutoresRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private ProprietariosRepository repository;
	
	@Autowired
	private MatrizesRepository mrepository;
	@Autowired
	private NascidosRepository nrepository;
	@Autowired
	private ReprodutoresRepository rrepository;

	@Override
	public void run(String... args) throws Exception {
		Proprietarios u1 = new Proprietarios(null, "Thiago");
		Proprietarios u2 = new Proprietarios(null, "Pablo");
		Proprietarios u3 = new Proprietarios(null, "Thayrone");
		Proprietarios u4 = new Proprietarios(null, "Silva");
		Proprietarios u5 = new Proprietarios(null, "Monteiro");
		repository.saveAll(Arrays.asList(u1,u2,u3,u4,u5));
		
		Matrizes m1 = new Matrizes(null, (long) 02, Instant.parse("2019-07-22T15:21:22Z"), u2);
		Matrizes m2 = new Matrizes(null, (long)01, Instant.parse("2019-07-22T15:21:22Z"), u1);
		mrepository.saveAll(Arrays.asList(m1,m2));
		
		Nascidos n1 = new Nascidos(null, (long)01, Instant.parse("2019-07-22T15:21:22Z"), "M", m2, u2);
		nrepository.saveAll(Arrays.asList(n1));
	
		
		Reprodutores r1 = new Reprodutores(null, (long)01, Instant.parse("2019-07-22T15:21:22Z"), u1);
		rrepository.saveAll(Arrays.asList(r1));
	}
	
	
	
}
