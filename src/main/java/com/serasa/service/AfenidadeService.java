package com.serasa.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serasa.domain.Afenidade;
import com.serasa.domain.Estado;
import com.serasa.repository.AfenidadeRepository;
import com.serasa.repository.EstadoRepository;

@Service
public class AfenidadeService {
	
	@Autowired
	AfenidadeRepository afenidadeRepository;
	
	@Autowired
	EstadoRepository estadoRepository;
	
	public Afenidade findById(Long id) {
		Optional<Afenidade> afenidade = afenidadeRepository.findById(id);
		return afenidade.orElseThrow(() -> new ObjectNotFoundException("Afenidade não encontrado para o Id: "+id));
	}
	
	@Transactional
	public Afenidade create(Afenidade afenidade) {
		afenidade.setId(null);
		afenidade = afenidadeRepository.save(afenidade);
		setListEstados(afenidade.getEstados(), afenidade);
		estadoRepository.saveAll(afenidade.getEstados());
		return afenidade;
	}
	
	public List<Afenidade> findAll() {
		return afenidadeRepository.findAll();
	}
	
	public void setListEstados(List<Estado> estados, Afenidade afenidade) {
		estados.forEach(x -> x.setAfenidade(afenidade));
	}
}
