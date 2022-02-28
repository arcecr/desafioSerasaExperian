package com.serasa.resource;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.serasa.domain.Afenidade;
import com.serasa.domain.dto.AfenidadeDTO;
import com.serasa.service.AfenidadeService;

@RestController
@RequestMapping("/afenidade")
public class AfenidadeResource {
	@Autowired
	AfenidadeService afenidadeService;
	
	@GetMapping("/{id}")
	public ResponseEntity<AfenidadeDTO> findByID(@PathVariable Long id){
		Afenidade afenidade = afenidadeService.findById(id);
		return ResponseEntity.ok().body(new AfenidadeDTO(afenidade));
	}
	@PostMapping
	public ResponseEntity<Afenidade> create(@RequestBody AfenidadeDTO afenidadeDTO){
		System.out.print(afenidadeDTO);
		Afenidade afenidade = new Afenidade(afenidadeDTO);

		afenidade = afenidadeService.create(afenidade);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(afenidade.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
