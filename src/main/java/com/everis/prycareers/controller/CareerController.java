package com.everis.prycareers.controller;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.everis.prycareers.documents.Career;
import com.everis.prycareers.services.CareerService;

import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/api/career")
public class CareerController {
	
	
	@Autowired
	private CareerService service;
	
	public Mono<ServerResponse> listar(ServerRequest request){
		return ServerResponse.ok()
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(service.findAll(), Career.class)
				.switchIfEmpty(ServerResponse.notFound().build());
	}
	
	public Mono<ServerResponse> forname(ServerRequest request){
		String name = request.pathVariable("name");
		
			return ServerResponse.ok()
					.contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(service.findByName(name), Career.class)
					.switchIfEmpty(ServerResponse.notFound().build());
	}
	
public Mono<ServerResponse> crear(ServerRequest request){
		
		Mono<Career> career= request.bodyToMono(Career.class);
		
		return career.flatMap(p->{
				return service.save(p);
		}).flatMap(p->ServerResponse.created(URI.create("api/career/".concat(p.getId())))
				.body(fromObject(p)));
	}

public Mono<ServerResponse> editar(ServerRequest request){
	Mono<Career> career= request.bodyToMono(Career.class);
	String id = request.pathVariable("id");
	
	Mono<Career> careerDB = service.findById(id);
	
	return careerDB.zipWith(career, (db,req)->{
		db.setName(req.getName());
		return db;
	}).flatMap(p->ServerResponse.created(URI.create("/api/career".concat(p.getId())))
			.contentType(MediaType.APPLICATION_JSON_UTF8)
			.body(service.save(p),Career.class))
			.switchIfEmpty(ServerResponse.notFound().build());
}

public Mono<ServerResponse> eliminar(ServerRequest request){
	String id = request.pathVariable("id");
	Mono<Career> careerDB = service.findById(id);
	return careerDB.flatMap(q->service.delete(q).then(ServerResponse.noContent().build()))
			.switchIfEmpty(ServerResponse.notFound().build());
}

}
