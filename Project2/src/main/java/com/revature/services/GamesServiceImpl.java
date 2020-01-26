package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Games;
import com.revature.repositories.GamesRepository;

@Service
public class GamesServiceImpl implements GamesService{

	@Autowired
	GamesRepository gr;

	@Override
	public Games getGameById(int id) {
		
		return gr.findById(id).get();
	}

	@Override
	public Games updateGame(Games game) {
		
		return gr.save(game);
	}

	@Override
	public Games addGame(Games game) {
		
		return gr.save(game);
	}

	@Override
	public List<Games> findByTitle(String title) {
		
		return gr.findByTitle(title);
	}

	@Override
	public boolean deleteGame(int id) {
		try {
			gr.deleteById(id);
			return true;
		} catch(IllegalArgumentException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Games> getAllGames() {
		
		return (List<Games>) gr.findAll();
	}
	
	
}
