package com.revature.services;

import java.util.List;

import com.revature.models.Genre;

public interface GenreService {

	public Genre createGenre(Genre genre);
	public Genre getGenreById(int id);
	public List<Genre> allGenres();
	public Genre updateGenre(Genre change);
	public boolean deleteGenre(Genre genre);
}