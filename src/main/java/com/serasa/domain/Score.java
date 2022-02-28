package com.serasa.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.serasa.domain.dto.ScoreDTO;

@Entity
public class Score implements Serializable {

	private static final long serialVersionUID = 1L;
	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	private String scoreDescricao;
	@Column(name = "inicial")
	private Integer scoreInicial;
	@Column(name = "final")
	private Integer scoreFinal;

	public Score() {
		super();
	}

	public Score(Long id, String scoreDescricao, Integer scoreInicial, Integer scoreFinal) {
		super();
		this.id = id;
		this.scoreDescricao = scoreDescricao;
		this.scoreInicial = scoreInicial;
		this.scoreFinal = scoreFinal;
	}

	public Score(ScoreDTO scoreDTO) {
		super();
		this.id = scoreDTO.getId();
		this.scoreDescricao = scoreDTO.getScoreDescricao();
		this.scoreInicial = scoreDTO.getScoreInicial();
		this.scoreFinal = scoreDTO.getScoreFinal();
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getScoreDescricao() {
		return scoreDescricao;
	}

	public void setScoreDescricao(String scoreDescricao) {
		this.scoreDescricao = scoreDescricao;
	}

	public Integer getScoreInicial() {
		return scoreInicial;
	}

	public void setScoreInicial(Integer scoreInicial) {
		this.scoreInicial = scoreInicial;
	}

	public Integer getScoreFinal() {
		return scoreFinal;
	}

	public void setScoreFinal(Integer scoreFinal) {
		this.scoreFinal = scoreFinal;
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
		Score other = (Score) obj;
		return Objects.equals(id, other.id);
	}

	
}
