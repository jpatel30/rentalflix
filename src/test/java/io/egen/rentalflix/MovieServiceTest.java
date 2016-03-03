package io.egen.rentalflix;

import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test cases for MovieService
 */
public class MovieServiceTest {

	MovieService instance = MovieService.getInstance();

	@Test
	public void findAll() {

		Assert.assertNotNull(instance.findAll());
	}

	@Test
	public void findByName() {

		Assert.assertNotNull(instance.findByName("Lagan"));
	}

	@Test
	public void create() {

		Movie movie = new Movie(5, "3 idiots", "2009", "Hindi", false);
		int size = instance.findAll().size();
		instance.create(movie);
		Assert.assertEquals(size + 1, instance.findAll().size());
	}

	@Test
	public void update() {

		Movie movie = new Movie(1, "SpiderMan", "2007", "English", true);
		Movie tempMovie = instance.update(movie);
		Assert.assertEquals(movie.getMovieYear(), tempMovie.getMovieYear());
	}

	@Test
	public void delete() {

		int size = instance.findAll().size();
		instance.delete(5);
		Assert.assertEquals(size - 1, instance.findAll().size());
	}

	@Test
	public void rentMovie() {

		Assert.assertTrue(instance.rentMovie(2, "egenSolutions"));
	}

}
