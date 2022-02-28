package com.serasa.domain.dto;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ScoreDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long id;
	private String scoreDescricao;
	@JsonProperty("inicial")
	private Integer scoreInicial;
	@JsonProperty("final")
	private Integer scoreFinal;

	public ScoreDTO() {
		super();
	}

	public ScoreDTO(Long id, String scoreDescricao, Integer scoreInicial, Integer scoreFinal) {
		super();
		this.id = id;
		this.scoreDescricao = scoreDescricao;
		this.scoreInicial = scoreInicial;
		this.scoreFinal = scoreFinal;
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
		ScoreDTO other = (ScoreDTO) obj;
		return Objects.equals(id, other.id);
	}

	
}
