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

import com.serasa.domain.Pessoa;
import com.serasa.domain.dto.PessoaDTO;
import com.serasa.service.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaResource {
	
	@Autowired
	PessoaService pessoaService;
	
	@GetMapping("/{id}")
	public ResponseEntity<PessoaDTO> findByID(@PathVariable Long id){
		PessoaDTO pessoaDTO = pessoaService.findById(id);
		return ResponseEntity.ok().body(pessoaDTO);
	}
	
	@GetMapping
	public ResponseEntity<List<PessoaDTO>> findAll(){
		List<PessoaDTO> listPessoaDTO = pessoaService.findAll();
		return ResponseEntity.ok().body(listPessoaDTO);
	}
	
	@PostMapping
	public ResponseEntity<PessoaDTO> create(@RequestBody PessoaDTO pessoaDTO){
		Pessoa pessoa = pessoaService.create(pessoaDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(pessoa.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
