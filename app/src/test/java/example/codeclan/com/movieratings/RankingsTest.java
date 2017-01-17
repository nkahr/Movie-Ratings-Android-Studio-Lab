package example.codeclan.com.movieratings;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by user on 16/01/2017.
 */

public class RankingsTest {

    Movie movie;
    Rankings rankings;

    @Before
    public void before() {
        movie = new Movie("Lord of the Rings", "Adventure", 8.7);
        rankings = new Rankings();
    }

    @Test
    public void canAddMovie() {
        rankings.addMovie(movie);
        assertEquals(movie, rankings.getMovies().get(rankings.numberOfMovies() - 1));
    }

    @Test
    public void canGetUnsortedMovieList() {
        assertNotNull(rankings.getMovies());
    }

    @Test
    public void getMovieByTitle() {
        rankings.addMovie(movie);
        Movie returned = rankings.findMovieByTitle("Lord of the Rings");
        assertEquals(movie, returned);
    }

    @Test
    public void getNumberOfMovies() {
        assertEquals(10, rankings.numberOfMovies());
    }

    @Test
    public void canSortMovies() {
        rankings.sortByRanking();
        assertEquals("The Shawshank Redemption", rankings.getMovies().get(0).getTitle());
        assertEquals("Pulp Fiction", rankings.getMovies().get(1).getTitle());
        assertEquals("The Dark Knight", rankings.getMovies().get(9).getTitle());
    }

    @Test
    public void addingMovieRemovesLowestRanked() {
        rankings.addMovie(movie);
        assertEquals(10, rankings.numberOfMovies());
        ArrayList<Movie> mov = rankings.getMovies();
        for (Movie m : mov) {
            System.out.println(m.toString());
        }
        assertNull(rankings.findMovieByTitle("The Dark Knight"));
    }

    @Test
    public void addMovieThatAlreadyExists() {
        Movie pulpFiction = rankings.findMovieByTitle("Pulp Fiction");
        assertEquals(2, rankings.getMovieRanking(pulpFiction));
        Movie duplicate = new Movie("Pulp Fiction", "Crime, Drama", 8.0);
        //try to add movie - movie already exists so rating is updated
        rankings.addMovie(duplicate);
        assertEquals(6, rankings.getMovieRanking(pulpFiction));
    }
}
