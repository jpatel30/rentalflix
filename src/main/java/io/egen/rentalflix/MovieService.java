package io.egen.rentalflix;

import java.util.ArrayList;
import java.util.List;

/**
 * Service implementing IFlix interface You can use any Java collection type to
 * store movies
 */
public class MovieService implements IFlix {

	private static MovieService instance = null;
	int i = 1;

	public static synchronized MovieService getInstance() {
		if (instance == null) {
			instance = new MovieService();
		}
		return instance;
	}

	ArrayList<Movie> movies;

	private MovieService() {
		movies = new ArrayList<Movie>();
		movies.add(new Movie(1, "SpiderMan", "2007", "English", false));
		movies.add(new Movie(2, "Batman", "2014", "English", false));
		movies.add(new Movie(3, "Lagan", "2005", "Hindi", true));
		movies.add(new Movie(4, "Mother India", "1990", "Hindi", false));
	}

	@Override
	public List<Movie> findAll() {

		return movies;
	}

	@Override
	public List<Movie> findByName(String name) {
		ArrayList<Movie> result = null;
		for (int i = 0; i < movies.size(); i++) {
			if (movies.get(i).getMovieTitle().contains(name)) {
				result = new ArrayList<Movie>();
				result.add(movies.get(i));
			}
		}
		return result;
	}

	@Override
	public Movie create(Movie movie) {
		movies.add(movie);
		return movie;
	}

	@Override
	public Movie update(Movie movie) {
		boolean check = false;
		for (int i = 0; i < movies.size(); i++) {
			if (movies.get(i).getMovieId() == movie.getMovieId()) {

				movies.get(i).setMovieLanguage(movie.getMovieLanguage());
				movies.get(i).setMovieTitle(movie.getMovieTitle());
				movies.get(i).setMovieYear(movie.getMovieYear());
				check = true;
			}
		}
		if (check)
			return movie;
		else
			throw new IllegalArgumentException();
	}

	@Override
	public Movie delete(int id) {
		Movie deletedMovie = null;
		boolean valid = false;
		for (int i = 0; i < movies.size(); i++) {
			if (movies.get(i).getMovieId() == id) {
				deletedMovie = movies.get(i);
				movies.remove(deletedMovie);
				valid = true;
			}

		}
		if (valid)
			return deletedMovie;
		else
			throw new IllegalArgumentException();

	}

	@Override
	public boolean rentMovie(int movieId, String user) {

		for (int i = 0; i < movies.size(); i++) {
			if (movies.get(i).getMovieId() == movieId) {
				if (!movies.get(i).isRentedMovie()) {
					return true;
				} else {
					throw new IllegalArgumentException("Movie is rented to"
							+ user);
				}
			}
		}
		return false;
	}

}
