package com.serasa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serasa.domain.Score;
import com.serasa.repository.ScoreRepository;
import com.serasa.service.exception.ObjectNotFoundException;

@Service
public class ScoreService {
	@Autowired
	ScoreRepository scoreRepository;

	public Score create(Score score) {
		return scoreRepository.save(score);
	}
	
	
	public List<Score> findAll() {
		return scoreRepository.findAll();
	}


	public Score findById(Long id) {
		Optional<Score> score = scoreRepository.findById(id);
		return score.orElseThrow(() -> new ObjectNotFoundException("Score não encontrado para o Id: "+id));
	
	}
	
	
}
