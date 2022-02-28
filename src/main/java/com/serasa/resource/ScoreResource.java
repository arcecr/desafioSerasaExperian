package com.serasa.resource;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.serasa.domain.Score;
import com.serasa.domain.dto.ScoreDTO;
import com.serasa.service.ScoreService;

@RestController
@RequestMapping("/score")
public class ScoreResource {
	
	@Autowired
	ScoreService scoreService;
	
	@PostMapping
	public ResponseEntity<Score> create(@RequestBody ScoreDTO scoreDTO){
		Score score = new Score(scoreDTO);

		score = scoreService.create(score);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(score.getId()).toUri();
		return ResponseEntity.created(uri).build();
	} 
}
