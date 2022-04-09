package com.model;

import java.util.List;

//import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
//import javax.persistence.OneToMany;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToOne;

@Entity
public class Authors {

	@Id
	int id;
	
	String name;

//	@OneToMany(mappedBy="author")
//	List<Books> book;
	public Authors() {
		
	}
	
	public Authors(int id, String name) {
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
