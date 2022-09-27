package com.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Books {

	
	@Id
	int id;
	String name;
	@ManyToOne(cascade=CascadeType.ALL)
	Authors author;
	String date;

	public Books(){
		
	}
	
	public Books(int id, String name, Authors author, String date) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.date = date;
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
	public Authors getAuthor() {
		return author;
	}
	public void setAuthor(Authors author) {
		this.author = author;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
