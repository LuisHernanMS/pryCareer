package com.everis.prycareers.services;

import com.everis.prycareers.documents.Career;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CareerService {

	public Flux<Career> findAll();
	
	public Mono<Career> findById(String id);
	
	public Flux<Career> findByName(String name);
	
	public Mono<Career> save(Career career);
	
	public Mono<Void> delete(Career career);
	
}
