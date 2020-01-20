package com.revature.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Games;

@Repository
public interface GamesRepository extends CrudRepository<Games, Integer>{

	public List<Games> findByTitle(String game);
		

}
