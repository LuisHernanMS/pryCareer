package com.everis.prycareers.dao;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.everis.prycareers.documents.Career;

import reactor.core.publisher.Flux;

public interface CareerDao extends ReactiveMongoRepository<Career, String>{

	@Query("{ name : ?0  }")
	public Flux<Career> obtenerPorName(String name);
	
}
