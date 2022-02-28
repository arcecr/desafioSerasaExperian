package com.serasa.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/{id}")
	public ResponseEntity<ScoreDTO> findByID(@PathVariable Long id){
		Score score = scoreService.findById(id);
		return ResponseEntity.ok().body(new ScoreDTO(score));
	}
	
	@GetMapping
	public ResponseEntity<List<ScoreDTO>> findAll(){
		List<Score> listScore = scoreService.findAll();
		List<ScoreDTO> listScoreDTO = listScore.stream().map(
				                        obj -> new ScoreDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listScoreDTO);
	}	
	
	@PostMapping
	public ResponseEntity<Score> create(@RequestBody ScoreDTO scoreDTO){
		Score score = new Score(scoreDTO);

		score = scoreService.create(score);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(score.getId()).toUri();
		return ResponseEntity.created(uri).build();
	} 
}
