package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.Books;
import com.service.BookService;

@RestController
public class BookController {

	@Autowired
	BookService service;
	
	@PostMapping("/addBook")
	public Books addBook(@RequestBody Books book) {
		return service.saveBook(book);
	}
//	@PostMapping("/addBooks")
//	public List<Books> addBook(@RequestBody List<Books> books) {
//		return (List<Books>) service.saveBooks(books);
//	}

	@GetMapping("/getBook/{id}")
	public Books getBookbyId(@PathVariable int id) {
		return service.getBookbyId(id);
	}
	@GetMapping("/getAllBooks")
	public List<Books> getAllBooks() {
		return service.getAllBooks();
	}
	
	@PutMapping("/updateBook")
	public Books updateBook(@RequestBody Books book) {
		return service.updateBooks(book);
	}
	
	@DeleteMapping("/deleteBook/{id}")
	public String deleteProduct(@PathVariable int id) {
		return service.deleteBook(id);
	}
		
}
