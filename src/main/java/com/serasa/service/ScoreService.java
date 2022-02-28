package com.serasa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serasa.domain.Score;
import com.serasa.repository.ScoreRepository;

@Service
public class ScoreService {
	@Autowired
	ScoreRepository scoreRepository;

	public Score create(Score score) {
		return scoreRepository.save(score);
	}
	
	
}
