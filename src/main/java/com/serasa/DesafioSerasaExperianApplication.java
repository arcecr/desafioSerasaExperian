package com.serasa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.serasa.domain.Afenidade;
import com.serasa.domain.Estado;
import com.serasa.domain.Pessoa;
import com.serasa.domain.Score;
import com.serasa.repository.AfenidadeRepository;
import com.serasa.repository.EstadoRepository;
import com.serasa.repository.PessoaRepository;
import com.serasa.repository.ScoreRepository;

@SpringBootApplication
public class DesafioSerasaExperianApplication implements CommandLineRunner {
	@Autowired
	AfenidadeRepository afenidadeRespository;
	@Autowired
	EstadoRepository estadoRespository;
	
	@Autowired
	PessoaRepository pessoaRepository;
	
	@Autowired
	ScoreRepository scoreRepository;
	
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
		afenidade.getEstados().addAll(estados);
		
		//estadoRespository.saveAll(estados);
		
		afenidadeRespository.save(afenidade);
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Fulano de Tal");
		pessoa.setTelefone("99 99999-9999");
		pessoa.setIdade(99);
		pessoa.setCidade("Cidade de Fulano");
		pessoa.setEstado("XX");
		pessoa.setScore(500); 
		pessoa.setRegiao("sudeste");
		pessoaRepository.save(pessoa);
		
		Score score = new Score();
		score.setScoreDescricao("Insulficiente");
		score.setScoreInicial(0);
		score.setScoreFinal(200);
		Score score1 = new Score();
		score1.setScoreDescricao("Inaceitavel");
		score1.setScoreInicial(201);
		score1.setScoreFinal(500);
		scoreRepository.saveAll(Arrays.asList(score, score1));
		
		List<Score> listaScores = scoreRepository.findAll();
		
		listaScores.stream().forEach(i -> {
			if(i.getScoreInicial()>pessoa.getScore()
			|| i.getScoreFinal()<=pessoa.getScore()) {				
				System.out.println(i.getScoreDescricao());
			}
		});
		
	}
}
