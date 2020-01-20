package com.revature.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Genre;
@Repository
public interface GenreRepository extends CrudRepository<Genre, Integer>{

}