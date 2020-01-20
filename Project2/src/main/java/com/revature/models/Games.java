package com.revature.models;



import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="games")
public class Games {

	@Id
	@Column(name="g_id")
	@SequenceGenerator(name = "games_seq", sequenceName = "games_seq")
	@GeneratedValue(generator = "games_seq",strategy = GenerationType.SEQUENCE)
	private int gameId; //Primary key
	
	@ManyToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(name="games_genres_jt",
				joinColumns = @JoinColumn(name="g_id"),
				inverseJoinColumns = @JoinColumn(name="gen_id"))
	private List<Genre> genres;
	
	@ManyToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(name="games_reviews_jt",
				joinColumns = @JoinColumn(name="g_id"),
				inverseJoinColumns = @JoinColumn(name="ge_id"))
	private List<Review> reviews;
	
	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public Games(int gameId, List<Genre> genres, List<Review> reviews, String title, double price, String image,
			String releaseDate, String rated, String description) {
		super();
		this.gameId = gameId;
		this.genres = genres;
		this.reviews = reviews;
		this.title = title;
		this.price = price;
		this.image = image;
		this.releaseDate = releaseDate;
		this.rated = rated;
		this.description = description;
	}

	@Column(name="title")
	private String title;
	
	@Column(name="price")
	private double price;
	
	@Column(name="photo")
	private String image;
	
	@Column(name="release_date")
	private String releaseDate;
	
	@Column(name="rated")
	private String rated;
	
	@Column(name="description")
	private String description;
	
//	@ManyToMany(fetch=FetchType.EAGER)
//	@JoinTable(name="games_genres_jt",
//				joinColumns = @JoinColumn(name="g_id"),
//				inverseJoinColumns = @JoinColumn(name="ge_id")) //This joins g_id column in Games table and ge_id in genres.
//	private List<Genre> genres;
	public Games(int gameId, String title, double price, String image, String releaseDate, String rated,
			String description) {
		super();
		this.gameId = gameId;
		this.title = title;
		this.price = price;
		this.image = image;
		this.releaseDate = releaseDate;
		this.rated = rated;
		this.description = description;
	}

	public Games(String title, double price, String image, String releaseDate, String rated, String description) {
		super();
		this.title = title;
		this.price = price;
		this.image = image;
		this.releaseDate = releaseDate;
		this.rated = rated;
		this.description = description;
	}
	public Games() {}

	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getRated() {
		return rated;
	}

	public void setRated(String rated) {
		this.rated = rated;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

//	public List<Genre> getGenres() {
//		return genres;
//	}
//
//	public void setGenres(List<Genre> genres) {
//		this.genres = genres;
//	}

	@Override
	public String toString() {
		return "Games [gameId=" + gameId + ", title=" + title + ", price=" + price + ", image=" + image
				+ ", releaseDate=" + releaseDate + ", rated=" + rated + ", description=" + description + "]";
	}

	
	
	
	
	
}
