package com.serasa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serasa.domain.Pessoa;
import com.serasa.domain.dto.PessoaDTO;
import com.serasa.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	PessoaRepository pessoaRepository;
	
	public Pessoa findById(Long id) {
		Optional<Pessoa> pessoa = pessoaRepository.findById(id);
		return pessoa.orElseThrow(() -> new ObjectNotFoundException("Pessoa não encontrado para o Id: "+id));
	}

	public Pessoa create(PessoaDTO pessoaDTO) {
		pessoaDTO.setId(null);
		Pessoa pessoa = new Pessoa(pessoaDTO);
		
		return pessoaRepository.save(pessoa);
	}

	public List<Pessoa> findAll() {
		return pessoaRepository.findAll();
	}
}
