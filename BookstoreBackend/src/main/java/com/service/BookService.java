package com.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.BooksDao;
import com.model.Books;


@Service
public class BookService {

	@Autowired
	 BooksDao dao;

	public Books saveBook(Books book) {
		return dao.save(book);
	}
//	public List<Books> saveBooks(List<Books> books){
//		return (List<Books>) dao.saveAll(books);
//	}
	public Books getBookbyId(int id) {
		return dao.findById(id).orElse(null);
	}
	public List<Books> getAllBooks(){
		return (List<Books>) dao.findAll();
	}
	
	public String deleteBook(int id) {
		Books book = dao.findById(id).orElse(null);		
		dao.delete(book);
		return "book deleted";
	}
	public Books updateBooks(Books book) {
		int id = book.getId();
		Books existingBook = dao.findById(id).orElse(null);
		existingBook.setName(book.getName());
		existingBook.setDate(book.getDate());
		existingBook.setAuthor(book.getAuthor());
		return dao.save(existingBook);
	}
	
}
