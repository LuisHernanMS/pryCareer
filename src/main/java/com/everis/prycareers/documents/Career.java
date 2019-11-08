package com.everis.prycareers.documents;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "careers")
public class Career {

	@Id
	private String id;
	
	@NotEmpty
	String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Career(@NotEmpty String name) {
		super();
		this.name = name;
	}
	
}
