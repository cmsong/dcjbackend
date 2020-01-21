package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Games;
import com.revature.models.Genre;
import com.revature.services.GamesService;
import com.revature.services.GenreService;

@RestController
public class GamesController {

	@Autowired
	GamesService gs;
	
	@Autowired
	GenreService ges;
	@CrossOrigin(origins="*")
	@PostMapping(value = "/games",consumes="application/json")
	public Games addGame(@RequestBody Games game) {
		return gs.addGame(game);
	}
	@CrossOrigin(origins="*")
	@GetMapping(value="/games")
	public List<Games> getAllGames(){
		return gs.getAllGames();
	}
	@CrossOrigin(origins="*")
	@GetMapping(value="/games/{id}")
	public Games getGameById(@PathVariable("id")int id) {
		return gs.getGameById(id);
	}
	@CrossOrigin(origins="*")
	@GetMapping(value="/games/search")
	public List<Games> findGamesByTitle(@RequestParam Games game){
		return gs.findByTitle(game);
	}
	@CrossOrigin(origins="*")
	@DeleteMapping(value="/games/{id}")
	public boolean deleteGame(@PathVariable("id") int id) {
		return gs.deleteGame(id);
	}
	@CrossOrigin(origins="*")
	@PutMapping(value="/games", consumes="application/json")
	public Games updateGame(@RequestBody Games game) {
		return gs.updateGame(game);
	}
	
	@CrossOrigin(origins="*")
	@PutMapping(value="/games/genre", consumes="application/json")
	public Games updateGameGenre(@RequestParam int g_id, @RequestParam int ge_id) {
		Games g = gs.getGameById(g_id);
		List<Genre> lg = g.getGenres();
		lg.add(ges.getGenreById(ge_id));
		g.setGenres(lg);
		return gs.updateGame(g);
	}
}
