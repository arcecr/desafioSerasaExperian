package com.serasa.domain.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.serasa.domain.Afenidade;
import com.serasa.domain.Estado;

public class AfenidadeDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String regiao;
	private List<Estado> estados = new ArrayList<>();

	public AfenidadeDTO() {
		super();
	}

	public AfenidadeDTO(Long id, String regiao, List<Estado> estados) {
		super();
		this.id = id;
		this.regiao = regiao;
		this.estados = estados;
	}

	public AfenidadeDTO(Afenidade obj) {
		super();
		this.id = obj.getId();
		this.estados = obj.getEstados();
		this.regiao = obj.getRegiao();
	}

	public String getRegiao() {
		return regiao;
	}

	public void setRegiao(String regiao) {
		this.regiao = regiao;
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

}
