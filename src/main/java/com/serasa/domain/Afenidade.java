package com.serasa.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.serasa.domain.dto.AfenidadeDTO;
@Entity
public class Afenidade {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String regiao;
	@JsonIgnore
	@OneToMany(mappedBy = "afenidade")
	private List<Estado> estados = new ArrayList<>();

	public Afenidade() {
		super();
	}

	public Afenidade(Long id, String regiao) {
		super();
		this.id = id;
		this.regiao = regiao;
	}
	
	public Afenidade(AfenidadeDTO obj) {
		this.id = obj.getId();
		this.regiao = obj.getRegiao();
		this.estados = obj.getEstados();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public String getRegiao() {
		return regiao;
	}

	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}

	
}
