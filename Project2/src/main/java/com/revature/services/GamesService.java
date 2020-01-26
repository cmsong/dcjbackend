package com.revature.services;

import java.util.List;

import com.revature.models.Games;

public interface GamesService {

	public Games getGameById(int id);
	public Games updateGame(Games game);
	public Games addGame(Games game);
	public List<Games> findByTitle(String title);
	public boolean deleteGame(int id);
	public List<Games> getAllGames();
}
