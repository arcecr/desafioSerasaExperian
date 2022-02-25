package com.serasa.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Estado implements Serializable {

	private static final long serialVersionUID = 1L;
	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "afenidade_id")
	private Afenidade afenidade;
	
	public Estado() {
		super();
	}

	public Estado(Long id, String nome, Afenidade afenidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.afenidade = afenidade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

		public Afenidade getAfenidade() {
		return afenidade;
	}

	public void setAfenidade(Afenidade afenidade) {
		this.afenidade = afenidade;
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
		Estado other = (Estado) obj;
		return Objects.equals(id, other.id);
	}

}
