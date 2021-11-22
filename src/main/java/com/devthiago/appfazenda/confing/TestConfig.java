package com.devthiago.appfazenda.confing;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.devthiago.appfazenda.entities.Bezerras;
import com.devthiago.appfazenda.entities.Bezerros;
import com.devthiago.appfazenda.entities.Matrizes;
import com.devthiago.appfazenda.entities.Proprietarios;
import com.devthiago.appfazenda.entities.Reprodutores;
import com.devthiago.appfazenda.repositories.BezerrasRepository;
import com.devthiago.appfazenda.repositories.BezerrosRepository;
import com.devthiago.appfazenda.repositories.MatrizesRepository;
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
	private BezerrosRepository nrepository;
	@Autowired
	private BezerrasRepository brepository;
	@Autowired
	private ReprodutoresRepository rrepository;

	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		Date y1 = sdf1.parse("25/07/1994");
		Proprietarios u1 = new Proprietarios(null, "Thiago");
		Proprietarios u2 = new Proprietarios(null, "Pablo");
		Proprietarios u3 = new Proprietarios(null, "Thayrone");
		Proprietarios u4 = new Proprietarios(null, "Silva");
		Proprietarios u5 = new Proprietarios(null, "Monteiro");
		repository.saveAll(Arrays.asList(u1,u2,u3,u4,u5));
		
		Matrizes m1 = new Matrizes(null, (long)01, y1, u1);
		mrepository.saveAll(Arrays.asList(m1));
	
		Bezerros b1 = new Bezerros(null, (long)01,  y1, m1, u1);
		nrepository.saveAll(Arrays.asList(b1));
		
		Bezerras b2 = new Bezerras(null, (long)01,  y1, m1, u1);
		brepository.saveAll(Arrays.asList(b2));
	
		
		Reprodutores r1 = new Reprodutores(null, (long)01, y1, u1);
		rrepository.saveAll(Arrays.asList(r1));
	}
}
