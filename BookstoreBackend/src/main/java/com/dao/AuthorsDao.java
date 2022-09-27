package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Authors;

@Repository
public interface AuthorsDao extends JpaRepository<Authors,Integer>{

}
