package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Genre;
import com.revature.services.GenreService;

@RestController
public class GenreController {
	@Autowired
	GenreService gs;
	@CrossOrigin(origins="*")
	@RequestMapping(value="/genres", method=RequestMethod.POST, consumes="application/json")
	public Genre createGenre(@RequestBody Genre genre) {
		return gs.createGenre(genre);
	}
	@CrossOrigin(origins="*")
	@GetMapping(value="/genres")
	public List<Genre> allGenres() {
		return gs.allGenres();
	}
	@CrossOrigin(origins="*")
	@GetMapping(value="/genres/{id}")
	public Genre getGenreById(@PathVariable("id") int id) {
		return gs.getGenreById(id);
	}
	@CrossOrigin(origins="*")
	@DeleteMapping(value="/genres/{id}")
	public boolean removeGenre(@PathVariable("id") int id) {
		return gs.deleteGenre(gs.getGenreById(id));
	}
	@CrossOrigin(origins="*")
	@PutMapping(value="/genres", consumes="application/json")
	public Genre updateGenre(@RequestBody Genre change) {
		return gs.updateGenre(change);
	}
}