package example.codeclan.com.movieratings;

/**
 * Created by user on 16/01/2017.
 */

public class Movie {

    double rating;
    String title;
    String genre;

    public Movie(String title, String genre, double rating) {
        this.title = title;
        this.genre = genre;
        this.rating = rating;
    }

    public String getTitle() {
        return this.title;
    }

    public String getGenre() {
        return this.genre;
    }

    public double getRating() {
        return this.rating;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Title: \'" + title + "\', Genre: \'" + genre + "\', Rating: " + rating;
    }

}
