package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Books;

@Repository
public interface BooksDao extends JpaRepository<Books,Integer>{

	List<Books> findByAuthor(String author);
	Books findByName(String name);
}
