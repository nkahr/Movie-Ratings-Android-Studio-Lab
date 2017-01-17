package example.codeclan.com.movieratings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by user on 16/01/2017.
 */

public class Rankings {

    ArrayList<Movie> movies;

    public Rankings() {
        this.movies = new ArrayList<Movie>();
        setup();
    }

    public Rankings(ArrayList<Movie> movies) {
        this.movies = new ArrayList<Movie>(movies);
    }

    //add movie if it does not already exist, sort by ranking after it is added
    //if it already exists, update rating
    public void addMovie(Movie movie) {
        if (findMovieByTitle(movie.getTitle()) == null) {
            this.movies.add(movie);
            sortByRanking();
            remove11thMovie();
        } else {
            findMovieByTitle(movie.getTitle()).setRating(movie.getRating());
            sortByRanking();
        }
    }

    private void remove11thMovie() {
        if (numberOfMovies() > 10) {
            this.movies.remove(10);
        }
    }

    public int getMovieRanking(Movie movie) {
        return this.movies.indexOf(movie) + 1;
    }

    public ArrayList<Movie> getMovies() {
        return new ArrayList<Movie>(this.movies);
    }

    public int numberOfMovies() {
        return this.movies.size();
    }

    public void sortByRanking() {
        Collections.sort(this.movies, new Comparator<Movie>() {
            @Override
            public int compare(Movie movie1, Movie movie2) {
                return (int) (movie2.getRating() * 10.0) - (int) (movie1.getRating() * 10.0);
            }
        });
    }

    public Movie findMovieByTitle(String title) {
        for (Movie movie : movies) {
            if (movie.getTitle() == title) {
                return movie;
            }
        }
        return null;
    }

    public void setup() {
        String[] titleArray = {
                "The Shawshank Redemption",
                "Pulp Fiction",
                "Forrest Gump",
                "Momento",
                "Casablanca",
                "Apocalypse Now",
                "The Dark Knight",
                "The Matrix",
                "Fight Club",
                "The Usual Suspects"
        };

        String[] genreArray = {
                "Crime, Drama",
                "Crime, Drama",
                "Comedy, Drama",
                "Thriller",
                "Romance",
                "Drama",
                "Action",
                "Sci-Fi",
                "Drama",
                "Crime, Drama"
        };

        double[] ratingArray = {
                9.4,
                8.7,
                8.4,
                7.9,
                8.1,
                7.8,
                6.9,
                8.2,
                7.1,
                8.3
        };

        Movie newMovie;
        for (int i = 0; i < 10; i++) {
            newMovie = new Movie(titleArray[i], genreArray[i], ratingArray[i]);
            addMovie(newMovie);
        }
    }

}
