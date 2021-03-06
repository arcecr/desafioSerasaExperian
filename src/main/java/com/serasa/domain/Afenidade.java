package com.serasa.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.serasa.domain.dto.AfenidadeDTO;
@Entity
public class Afenidade implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String regiao;
	@JsonIgnore
	@OneToMany(mappedBy = "afenidade", cascade=CascadeType.ALL)
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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Afenidade other = (Afenidade) obj;
		return Objects.equals(id, other.id);
	}

	
	
}
