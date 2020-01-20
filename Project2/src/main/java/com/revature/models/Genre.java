package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Genre {
	@Id
	@GeneratedValue
	private int ge_id;
	@Column
	private String genre;
	
	public Genre() {
		
	}
	public Genre(int ge_id, String genre) {
		super();
		this.ge_id = ge_id;
		this.genre = genre;
	}
	public int getGe_id() {
		return ge_id;
	}
	public void setGe_id(int ge_id) {
		this.ge_id = ge_id;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	@Override
	public String toString() {
		return "Genre [ge_id=" + ge_id + ", genre=" + genre + "]";
	}
	
	
}