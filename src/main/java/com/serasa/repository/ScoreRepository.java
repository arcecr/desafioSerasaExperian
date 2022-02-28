package com.serasa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.serasa.domain.Score;

public interface ScoreRepository extends JpaRepository<Score, Long>{

}
