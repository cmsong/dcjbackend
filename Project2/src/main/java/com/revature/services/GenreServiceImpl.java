package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Genre;
import com.revature.repositories.GenreRepository;
@Service
public class GenreServiceImpl implements GenreService{
	@Autowired
	GenreRepository gr;

	@Override
	public Genre createGenre(Genre genre) {
		gr.save(genre);
		return genre;
	}

	@Override
	public Genre getGenreById(int id) {
		return gr.findById(id).get();
	}

	@Override
	public List<Genre> allGenres() {
		return (List<Genre>)gr.findAll();
	}

	@Override
	public Genre updateGenre(Genre change) {
		return gr.save(change);
	}

	@Override
	public boolean deleteGenre(Genre genre) {
		try {
			gr.delete(genre);
			return true;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return false;
		}
	}

}