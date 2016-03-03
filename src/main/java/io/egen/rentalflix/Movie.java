package io.egen.rentalflix;

import lombok.Data;

/**
 * Entity representing a movie.
 * Fields: id, title, year, language
 */
@Data
public class Movie {
	
	private int movieId;
	private String movieTitle;
	private String movieYear;
	private String movieLanguage;
	private boolean rentedMovie;
	
	
	public Movie(int movieId, String movieTitle, String movieYear,
			String movieLanguage, boolean rentedMovie) {
		super();
		this.movieId = movieId;
		this.movieTitle = movieTitle;
		this.movieYear = movieYear;
		this.movieLanguage = movieLanguage;
		this.rentedMovie=rentedMovie;
	}
	
	
	
	
}
