package com.serasa.domain.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.serasa.domain.Estado;
import com.serasa.domain.Pessoa;

public class PessoaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataInclusao = LocalDate.now();
	private String nome;
	private String telefone;
	private Integer idade;
	private String cidade;
	private String estado;
	@JsonIgnore
	private String regiao;
	@JsonIgnore
	private Integer score;
	
	private String scoreDescricao;
	private List<String> estados;

	public PessoaDTO() {
		super();
	}

	public PessoaDTO(Pessoa obj) {
		super();
		this.id = obj.getId();
		this.dataInclusao = obj.getDataInclusao();
		this.nome = obj.getNome();
		this.telefone = obj.getTelefone();
		this.idade = obj.getIdade();
		this.cidade = obj.getCidade();
		this.estado = obj.getEstado();
		this.regiao = obj.getRegiao();
		this.score = obj.getScore();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(LocalDate dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getRegiao() {
		return regiao;
	}

	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getScoreDescricao() {
		return scoreDescricao;
	}

	public void setScoreDescricao(String scoreDescricao) {
		this.scoreDescricao = scoreDescricao;
	}

	public List<String> getEstados() {
		return estados;
	}

	public void setEstados(List<String> estados) {
		this.estados = estados;
	}
	
	
	
	
	
	

}
