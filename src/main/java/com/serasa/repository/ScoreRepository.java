package com.serasa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.serasa.domain.Score;
@Repository
public interface ScoreRepository extends JpaRepository<Score, Long>{
	@Query("SELECT scoreDescricao FROM Score s where :valor between s.scoreInicial and s.scoreFinal")
	String findValorByScoreDescricao(@Param("valor") Integer valor);

}
