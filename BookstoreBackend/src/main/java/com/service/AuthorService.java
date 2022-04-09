package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.AuthorsDao;
import com.model.Authors;

@Service
public class AuthorService {

	@Autowired
	 AuthorsDao dao;

	public Authors saveAuthor(Authors author) {
		return dao.save(author);
	}
//	public List<Books> saveBooks(List<Books> books){
//		return (List<Books>) dao.saveAll(books);
//	}
	public Authors getAuthorbyId(int id) {
		return dao.findById(id).orElse(null);
	}
	public List<Authors> getAllAuthors(){
		return (List<Authors>) dao.findAll();
	}
	
	public String deleteAuthor(int id) {
		Authors author = dao.findById(id).orElse(null);		
		dao.delete(author);
		return "author deleted";
	}
	public Authors updateAuthors(Authors author) {
		int id = author.getId();
		Authors existingAuthor = dao.findById(id).orElse(null);
		existingAuthor.setName(author.getName());
		return dao.save(existingAuthor);
	}
}
