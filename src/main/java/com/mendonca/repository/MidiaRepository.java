package com.mendonca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mendonca.model.Music;


@Repository
public interface MidiaRepository extends  JpaRepository<Music, Integer>   {

	
	
	
	
}
