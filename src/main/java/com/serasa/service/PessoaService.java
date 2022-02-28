package com.serasa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serasa.domain.Estado;
import com.serasa.domain.Pessoa;
import com.serasa.domain.dto.PessoaDTO;
import com.serasa.repository.AfenidadeRepository;
import com.serasa.repository.PessoaRepository;
import com.serasa.repository.ScoreRepository;
import com.serasa.service.exception.ObjectNotFoundException;

@Service
public class PessoaService {

	@Autowired
	PessoaRepository pessoaRepository;
	@Autowired
	ScoreRepository scoreRepository;
	@Autowired
	AfenidadeRepository afenidadeRepository;

	public PessoaDTO findById(Long id) {
		Optional<Pessoa> pessoa = pessoaRepository.findById(id);
		if (pessoa.isPresent()) {
			Pessoa newPessoa = pessoa.get();
			PessoaDTO pessoaDTO = new PessoaDTO(newPessoa);
			pessoaDTO = retornaDadosAdicionaisPessoa(pessoaDTO);
			return pessoaDTO;
		}

		throw new ObjectNotFoundException("Pessoa não encontrado para o Id: " + id);

	}

	public Pessoa create(PessoaDTO pessoaDTO) {
		pessoaDTO.setId(null);
		Pessoa pessoa = new Pessoa(pessoaDTO);

		return pessoaRepository.save(pessoa);
	}

	public List<PessoaDTO> findAll() {
		List<Pessoa> listPessoas = pessoaRepository.findAll();
		List<PessoaDTO> pessoasDTO = new ArrayList<>();

		for (Pessoa pessoa : listPessoas) {
			PessoaDTO pessoaDTO = new PessoaDTO(pessoa);
			pessoaDTO = retornaDadosAdicionaisPessoa(pessoaDTO);
			pessoasDTO.add(pessoaDTO);
		}

		return pessoasDTO;
	}

	public PessoaDTO retornaDadosAdicionaisPessoa(PessoaDTO pessoaDTO) {
		retornaDadosScore(pessoaDTO);
		retornaDadosRegiao(pessoaDTO);

		return pessoaDTO;
	}

	public void retornaDadosScore(PessoaDTO pessoaDTO) {
		pessoaDTO.setScoreDescricao(scoreRepository.findValorByScoreDescricao(pessoaDTO.getScore()));
	}

	public void retornaDadosRegiao(PessoaDTO pessoaDTO) {
		List<String> estados = afenidadeRepository.findByRegiao(pessoaDTO.getRegiao());
		pessoaDTO.setEstados(estados);
	}
}
