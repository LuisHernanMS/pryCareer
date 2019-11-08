package com.everis.prycareers.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.everis.prycareers.dao.CareerDao;
import com.everis.prycareers.documents.Career;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class CareerServiceImpl implements CareerService{
	
	@Autowired
	private CareerDao dao;

	@Override
	public Flux<Career> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Mono<Career> findById(String id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public Flux<Career> findByName(String name) {
		// TODO Auto-generated method stub
		return dao.obtenerPorName(name);
	}

	@Override
	public Mono<Career> save(Career career) {
		// TODO Auto-generated method stub
		return dao.save(career);
	}

	@Override
	public Mono<Void> delete(Career career) {
		// TODO Auto-generated method stub
		return dao.delete(career);
	}

}
