package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.Authors;

import com.service.AuthorService;

@RestController
@CrossOrigin(value="*")
public class AuthorController {

	@Autowired
	AuthorService service;
	
	@PostMapping("/addAuthor")
	public Authors addAuthor(@RequestBody Authors author) {
		return service.saveAuthor(author);
	}
//	@PostMapping("/addBooks")
//	public List<Books> addBook(@RequestBody List<Books> books) {
//		return (List<Books>) service.saveBooks(books);
//	}

	@GetMapping("/getAuthor/{id}")
	public Authors getAuthorbyId(@PathVariable int id) {
		return service.getAuthorbyId(id);
	}
	@GetMapping("/getAllAuthors")
	public List<Authors> getAllAuthors() {
		return service.getAllAuthors();
	}
	
	@PutMapping("/updateAuthor")
	public Authors updateAuthor(@RequestBody Authors author) {
		return service.updateAuthors(author);
	}
	
	@DeleteMapping("/deleteAuthor/{id}")
	public String deleteProduct(@PathVariable int id) {
		return service.deleteAuthor(id);
	}
}
