package com.serasa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.serasa.domain.Afenidade;

@Repository
public interface AfenidadeRepository extends JpaRepository<Afenidade, Long>{
	@Query("SELECT b.nome FROM Afenidade a INNER JOIN a.estados b")
	List<String> findByRegiao(String regiao);

}
