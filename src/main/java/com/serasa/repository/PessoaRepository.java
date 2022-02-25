package com.serasa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.serasa.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
