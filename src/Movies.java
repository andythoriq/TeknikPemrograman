import java.util.ArrayList;

public class Movies {
    private ArrayList<Movie> movies;

    // Constructor menerima daftar film
    public Movies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public void displayMovies() {
        for (Movie movie : movies) {
            System.out.println(movie.getTitle() + " - " + movie.getGenre() + " (" + movie.getDuration() + " min)");
        }
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }
}