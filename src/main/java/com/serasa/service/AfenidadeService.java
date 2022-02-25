package com.serasa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serasa.domain.Afenidade;
import com.serasa.domain.Pessoa;
import com.serasa.domain.dto.AfenidadeDTO;
import com.serasa.repository.AfenidadeRepository;

@Service
public class AfenidadeService {
	
	@Autowired
	AfenidadeRepository afenidadeRepository;
	
	public Afenidade findById(Long id) {
		Optional<Afenidade> afenidade = afenidadeRepository.findById(id);
		return afenidade.orElseThrow(() -> new ObjectNotFoundException("Afenidade não encontrado para o Id: "+id));
	}

	public Afenidade create(AfenidadeDTO afenidadeDTO) {
		afenidadeDTO.setId(null);
		Afenidade afenidade = new Afenidade(afenidadeDTO);
		
		return afenidadeRepository.save(afenidade);
	}

	public List<Afenidade> findAll() {
		return afenidadeRepository.findAll();
	}
}
