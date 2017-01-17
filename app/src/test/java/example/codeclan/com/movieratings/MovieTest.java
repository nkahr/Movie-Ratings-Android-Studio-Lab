package example.codeclan.com.movieratings;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 16/01/2017.
 */

public class MovieTest {

    Movie movie;

    @Before
    public void before() {
        movie = new Movie("Lord of the Rings", "Adventure", 8.7);
    }

    @Test
    public void canGetTitle() {
        assertEquals("Lord of the Rings", movie.getTitle());
    }

    @Test
    public void canSetTitle() {
        movie.setTitle("Lord of the Flies");
        assertEquals("Lord of the Flies", movie.getTitle());
    }

    @Test
    public void canGetGenre() {
        assertEquals("Adventure", movie.getGenre());
    }

    @Test
    public void canSetGenre() {
        movie.setGenre("Fantasy");
        assertEquals("Fantasy", movie.getGenre());
    }

    @Test
    public void canGetRating() {
        assertEquals(8.7, movie.getRating(), 0.01);
    }

    @Test
    public void canSetRating() {
        movie.setRating(9.1);
        assertEquals(9.1, movie.getRating(), 0.01);
    }

    @Test
    public void convertToString() {
        System.out.println(movie.toString());
        assertEquals("Title: 'Lord of the Rings', Genre: 'Adventure', Rating: 8.7", movie.toString() );
    }




}
