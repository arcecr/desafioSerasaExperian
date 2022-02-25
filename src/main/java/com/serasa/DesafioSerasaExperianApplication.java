package com.serasa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.serasa.domain.Afenidade;
import com.serasa.domain.Estado;
import com.serasa.repository.AfenidadeRepository;
import com.serasa.repository.EstadoRepository;

@SpringBootApplication
public class DesafioSerasaExperianApplication implements CommandLineRunner {
	@Autowired
	AfenidadeRepository afenidadeRespository;
	@Autowired
	EstadoRepository estadoRespository;
	
	public static void main(String[] args) {
		SpringApplication.run(DesafioSerasaExperianApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Estado> estados = new ArrayList<>();
		Afenidade afenidade = new Afenidade(null,"Sudeste");
		Estado est1 = new Estado(null,"SP",afenidade);
		Estado est2 = new Estado(null,"MG",afenidade);
		estados.add(est1);
		estados.add(est2);
		

		afenidadeRespository.save(afenidade);
		estadoRespository.saveAll(estados);
		
	}
}
